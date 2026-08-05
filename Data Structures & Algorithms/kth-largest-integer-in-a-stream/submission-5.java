class KthLargest {
    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();

        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);

        if (minHeap.size() > k) {
            minHeap.poll();
        }

        return minHeap.peek();
    }
}

/*
    fIND THE KTH LARGEST INTEGER
    - Steam isn't sorted
    - Duplicates are allowed
    
    Design:
    - Add:
        adds a number into the current stream
        return the kth largest after that number has been added

    constructor which incorporates a pre assigned list of nums and the value k which is the biggest we are looking at

    Logic:
    - whenever we are looking for a value
    - we only care about the kth biggest values
    - in which case sorting doesn't need to cover the entire list + it's taxing do so after every add operation
    - instead we can partially sort items up to k since that's all we care about
    - this is where a heap would be usefull since each time we have excess values ie. over k number of items, we simply pop
    that way, the kth largest would be at the top of a min heap
    

*/