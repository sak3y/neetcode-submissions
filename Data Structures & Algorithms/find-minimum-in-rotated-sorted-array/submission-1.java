class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int res = nums[0];

        while (l <= r) {
            // Sorted
            if (nums[l] < nums[r]) {
                res = Math.min(res, nums[l]);
                break;
            }

            int m = (l + r) / 2;
            res = Math.min(res, nums[m]);

            // Figuring out which sorted sub array is bigger
            if (nums[m] >= nums[l]) {
                l = m + 1;
            }
            else {
                r = m - 1;
            }
        }
        return res;
    }
}

/*
    GOAL
    Find the smallest number in array

    INTUITION
    - Originally the array was sorted
    - We need to find a O(logn) solution => binary search

    1. Need to figure out how to rotate it so that it's ordered
    2. Return index 0 => which should be the smallest, given the array is sorted

    Rotations occur between 1 and n, where n is the length or the array

    IMPLEMENTATION

    BRUTE FORCE => Go thru each index and search, one by one => O(n)

    OPTIMISED
    - fIGURE OUR HOW TO REVERSES THE ROTATION SO THAT THE ARRAY IS SORTED>
    - we know that ignoring the start and end indexes, the array is asscending depening on a given index.
    - we know which index that is by looking at an index and index + 1.
    - If we look at index 2 in ex1. The next values is increasing so that isn't our rotation.
    - At index 3, we see the next number is smaller than the previosu => we found our rotation which is i + 1 so 4
    - moving each index 4 back will result in the orginal sorted array.
    - The issuee with that is we have just found the smallest

    [4, 5, 0, 1, 2, 3] => here m and r are in the same bracket. No matter what m is going to belong to either the bigger sorted array
     l     m        r  

    we know that if m and r are in the same bracket => then the split lies between l and m and vice-versa
    r becomes m at that stage

    [4, 5, 0, 1, 2, 3]
     l  m  r         

    know that m > r
    soltuiion lies between m and r.
    updaet l 

    [4, 5, 0, 1, 2, 3]
        l  r
        m

    know that l == m
    r has to be the soltuion because that's exactly where the split is

    binary search -> array needs to be sorted. 

    [3, 4, 5, 6, 7, 8, 1, 2]
     l        m           r

    [3, 4, 5, 6, 7, 8, 1, 2]
              l     m     r

    [3, 4, 5, 6, 7, 8, 1, 2]
                    l  m  r

    [3, 4, 5, 6, 7, 8, 1, 2]
                    l  r                  

    know we see that the condition we needed to meet was l > m < r so essentiatly m is our values.


    becasue l and m are are in sorted order and r is the odd one out, based of the first parse we know that the bigger sorted
    section is in the left hand side.
    We knwo that r < l & m, so the smaller section must be on the right section

    [3, 4, 5, 6] [1, 2] => two sorted arrays (smallest always fall in the 1 index of the right array)
           
    

*/