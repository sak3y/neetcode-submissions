class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

        for (int stone : stones) maxHeap.offer(-stone);
        
        while (maxHeap.size() > 1) {
            int first = maxHeap.poll();
            int second = maxHeap.poll();

            if (second > first) {
                maxHeap.offer(first - second);
            }

        }
        return maxHeap.isEmpty() ? 0 : -maxHeap.poll();
        
    }
}

/*
    Given a list of stones
    if x == y then they get destroyed
    and if x > y then the smaller gets destroyed and the bigger when is left with the complement of the two
    CAVIAT -> we have to smash the two biggest stones at any given time

    GOAL: Find the resulting weight of the last remaining stone after all process

    BRUTE FORCE
    - we order the list
    - take the two biggest
    - compare
    - if they are equal we destroy both AKK remove them from the list
    - if one is bigger than the other, 
        calculate the complement of the two and update the weight for the bigger one
        remove the smaller one
    - since we have an updated list that isn't sorted, we need to re-order the list
    TC: O(nlogn) => on every execution

    OPTIMISED
    - We can't change the order of smashing
    - we always have to smash the two biggest ones.
    - That means we only care about the two biggest at any given time
    - So we only need a partially sorted array 
    - Therefore, should use a max heap that is only going to have two element at any given time. That way we konw exactly what the two biggest elements are
    - On each iteration, we need to update the heap,
    

    IMPLEMENTATION
    - Create max heap
    - Push element from list into heap, pop when size is greater than two
    - perform operation on the two elemetns by popping them
    - heap is empety 
*/