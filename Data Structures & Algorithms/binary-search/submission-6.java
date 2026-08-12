class Solution {
    public int search(int[] nums, int target) {
        return bs(nums, target, 0, nums.length - 1);

    }

    private int bs(int[] nums, int target, int l, int r) {
        if (l > r) return -1;
        int mid = l + (r - l) / 2;

        if (nums[mid] == target) return mid;
        if (nums[mid] < target) {
            return bs(nums, target, mid + 1, r);
        }
    
            return bs(nums, target, l, mid - 1);
      
    }
}
/*
    Recusrive bs approch
    - idea is that we divide and conquere
    - limit one half at a time
    - 
*/