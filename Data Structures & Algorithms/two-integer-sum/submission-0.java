class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        
        for (int l = 0; l < nums.length - 1; l++){
            for (int r = l + 1; r < nums.length; r++){
                if (nums[l] + nums[r] == target) {
                    res[0] = l;
                    res[1] = r;
                    return res;
                }
            }
        }
        return res;
    }
}

/*
    Rules and Assumptions:
    - There always exists a pair x and y such that x + y = target
    - Therefore array size must be at least size 2
    - If there exists multiple solutions, return the smallest index
    - Solution must exist across two different indexes

    Edge cases:
    - Array size is 2, return [0, 1]
    - Negatives numbers -> nothing needs to be changed

    Solution:
    - Two pointer solution, O(n^2)
    - L starts at index 0, R is at l + 1. 
    - R moves the end of the list one step at a time
    - On each repetition, L moves across by one and subsaquently R resets to l + 1
*/