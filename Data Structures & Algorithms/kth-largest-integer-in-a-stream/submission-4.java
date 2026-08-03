class KthLargest {
    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>();

        for (int num : nums) add(num);

    }
    
    public int add(int val) {
        pq.offer(val);

        if (pq.size() > k) pq.poll();

        return pq.peek();
    }
}


/*
    Find the kth largest integer in a steam
    The stream changes with the add function.
    To find the kth largest,
    stream needs to be sorted
    then we just pick from the end, the kth largest
    But with the add function, the list becomes unsorted
    That means we need to resort it if we want to find the kth largest
    
    Solution
    - since only part of the list needs to be sorted, i.e, the values leading up to k, 
    - using a heap, we can add values until we reach a: k size, in which case we pop it
    - a min heap will then hold the values in which the value at the top will be the smallest
    - in which case we pop
    - using a add funciton, the values will sort themselves into the treee

*/