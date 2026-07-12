class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
         
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
/*
    INTUITION
    Looking for target => return the index
    O(logn) solution
    It's already sorted => sort algo: O(nlogn)

    EXAMPLE
    [-1, 0, 2], [4, 6, 8]

    [-1], [0, 2], [4], [6, 8]

    [-1], [0], [2], [4], [6], [8]
                ^
    4 > 2

    => [4], [6], [8]
             ^

    4 < 6

    [4] => Solution

    3 tries => implement O(logn)

    IMPLEMENTATION
    - have a pointer at the middle => odd length => len + 1 / 2, even len / 2
    - ask, is target equal to value? YES => END search
    - NO => is it less than or greeater than
    - if Greater => have a point at the start and then another one at the ends, eliminate the left side => don't look at at it and the evalute
    the right side of the array
    - we take the middle value of that



    EDGE CASES
    - Target does not exists in the array => return -1 in this case
    - 
*/