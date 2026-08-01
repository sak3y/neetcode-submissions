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
        minHeap.add(val);

        while (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
/*

    Here we are looking for kth largest in a stream
    - whenver we add a value to that stream, we want to get new
    kth largest element
    - duplicates are inlcuded => doesnt matter whcih one


    Need to:
    - create the constructor which initialises a stream
    - create an add method that adds values to the stream and 
        returns the new kth largestt

    BRUTE FORCE
    - create the array from the current list
    - whenver values are added, sort the list in ascending order
    - return the kth value from the end
    TC: O(nlogn)

    More efficient is to sort it once tthen insert using binary search, it's still O(nlogn) but it's not being sorted each time

    HEAPS
    - the way heaps works is, for a minHeap, the smallest value is always on the top and children go down in descending order
    - if we create a heap with thet top three biggest values
    - and then add ot our heap each time we gett an element, since a property of the heap is thatt childern are descending,
    elements will place tthemselves in the correct positions and we ill always have the smalles child.
    - in a heap of size k, thtat means our k values lives in the top
    - we can use this by using heap peak to get our k value
*/