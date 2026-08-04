class Solution {
    public int leastInterval(char[] tasks, int n) {
        // Get the frequencies of the char
        Map<Character, Integer> freq = new HashMap<>();
        for (char task : tasks) {
            freq.put(task, freq.getOrDefault(task, 0) + 1);
        }

        // Initiliase heap with most frequent chars
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq.values()) {
            maxHeap.add(f);
        }
        
        // Cycle
        int time = 0;
        Queue<int[]> q = new LinkedList<>();
        while (!q.isEmpty() || !maxHeap.isEmpty()) {
            time++;

            if (maxHeap.isEmpty()) {
                time = q.peek()[1];
            }
            else {
                int count = maxHeap.poll() - 1;
                if (count > 0) {
                    q.add(new int[]{count, time + n});
                }
            }
            if (!q.isEmpty() && q.peek()[1] == time) {
                maxHeap.add(q.poll()[0]);
            }
        }

        return time;
    }
}

/*
    Given a list of cpu tasks
    return the minimum numbers of cycles required to complete all tasks
    Similar tasks need to be at least n cycles away from each other
    Ex. if n = 3, and there are two actions: A. Then there needs to be 3 tasks between those two.

    We use non similar cycles to fill up the gaps
    and we need to keep track of where similar cycles are so that we can space them properly

    Brute force solution
    - we need to keep an active tab of the elements as wee add them. For exmample
    - say we add A into our list
    - then we need a hashmap that keep track of how far away each values is
    - as we move along our list, we update that value and when it's greater than n, then we know
   it's safe to index that
    - we use a greedy approach to place any element that we have as soon as we can

    Hashmpap
    - we track each element and their count
    - we place higher frequency chars first
    - We keep track of their cooldowns?
        The idea here is we are creating a list of chars
        we push chars at higher frequency first
        we a char is pushed it's on a cooldown of n
        as we push more vlaues that cooldown reduces
        we then need to place chars that have just finished cooldown
        HOW DO WE TRACK COOLDOWN

    Solution
    - Frequency of each char in list using a hashmap
    - know that the most frequent chars should be placed first
    - Use a maxHeap to place the most frequent char at the current time
    - we pop from teh max heap
    - update list, and also store what time the cooldown is
    - we check our qeuue to see if the current time matches the end of the queue, if it does, pop from teh q, add it back to the stack and decrement the value by 1

*/