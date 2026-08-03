class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) pq.poll();
        }

        return pq.peek();
    }
}

/*
    Looking for kth largest element in an array
    
    array is unsorted
    to do this we need to at least have the array is descending order paritally,
    then pick out the kth value from the end
    this can be done with a heap.

    Minheap woudl work here
    - simply add all values into a heap
    - then we pop our values size - k times
    - that way, our kth value is sitting at the top
*/