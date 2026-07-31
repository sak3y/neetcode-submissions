class KthLargest {
    int k;
    PriorityQueue<Integer> minHeap;


    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap = new PriorityQueue<>();

        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size() > k) minHeap.poll();
        return minHeap.peek();
    }
}

/*
    we need to create a method
    kthlargest -> initiliases a stream 
    add => it updatest the stream and return the values at k

    add methods needs to return the kth largest integer

    how do we do that?
    - we can sort the array before we return the kth largest => O(nlogn) for every add method
    - the process:
        - have a dynamically changing list that needs to stay ordered
        - what the best possible way to do that?
        - we don't want to sort on each operation because that is expensive
        - 
*/