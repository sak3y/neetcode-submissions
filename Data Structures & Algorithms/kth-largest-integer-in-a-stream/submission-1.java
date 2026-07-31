class KthLargest {
    int k;
    int[] nums;
    List<Integer> arr = new ArrayList<>();


    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.nums = nums;

        for (int num : nums) {
            arr.add(num);
        }
    }
    
    public int add(int val) {
        

        arr.add(val);

        Collections.sort(arr);

        return arr.get(arr.size() - k);
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