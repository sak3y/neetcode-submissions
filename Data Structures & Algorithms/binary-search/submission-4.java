class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l +(r - l) / 2;

            if (nums[mid] == target) return mid;

            else if (target < nums[mid]) {
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }
        return -1;
    }
}

/*
    Given DISTINCT integer nums that's sorted
    Find target in O(logn) time
    Otherwise return -1

    Sorted => Binary search
    , we are given a target. 
    Reminder on how BS words
    You start in the middle of the array
    If that number in the middle is greater then your target
        Eliminate the right half then go to the middle of the left half
    Otherwise do the same with the left half and move to right half
    Rinse and repeat
*/