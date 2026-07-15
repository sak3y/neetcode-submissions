class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = (l + r) / 2;

            if (target == nums[mid])
                return mid;

            // is left half is sorted
            if (nums[l] <= nums[mid]) {
                if (target >= nums[l] && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }

            // right half is sorted
            else {
                if (target <= nums[r] && target > nums[mid]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }
}
/*
    INTUITION
    - A sorted array has been shifted x times

    GOAL => find the index of target if present in O(logn)

    EDGE CASES
    - Return -1 if not found
    - All numbers are unique

    BRUTEFORCE
    - O(n) solution which is to look at each index and see

    OPTIMISED
    = Binary search =< since it's not fully sorted
    - instead we have two sorted arrays

    [3,4,5,6,1,2]       [6,7,1,2,3,4,5]
    l    m     r        l    m     r

    [3,4,5,6,1,2]       [6,7,1,2,3,4,5] => because we know split is between l and r
    l    m     r        l  m   r

    => since l > r, we know that the array has been shifted
    we also know that there are two parts to the sorted sub array
    - the first part to this problem is fiuring outt how to nagivatte
    the two different sub arrays since we can't perform binary search
    unless we know that.
    There r a few ways to do that:
    - using binary search, using l, m and r as indicators
    in this ex. r < l < m.
    Since m > r, we know that the larger array is on the left side.
    becaues we are looking for 4

    if l < m:
        we know that there isn't a reset in between so those vlaues are ordered
    if m < r:
        ordered, so values within these ranges we cna predicts since there isn't a split there

    as such
    if target doesn't lie betweeen l <= m:
        then it must be between target > m
            so we move our l pointer to m
    if target doesn't lie betweeen m <= r:
        then it must be between target < m
            so we move our r pointer to m


*/