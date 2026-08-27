class Solution {
    public int rob(int[] nums) {
         return Math.max(nums[0],
               Math.max(dp(Arrays.copyOfRange(nums, 1, nums.length)),
               dp(Arrays.copyOfRange(nums, 0, nums.length - 1))));
    }

    private int dp(int[] nums) {
        int prev2 = 0;
        int prev1 = 0;

        for (int num : nums) {
            int cur = Math.max((prev2 + num), prev1);
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }
}

/*
    GOAL: Rob the most amm of money
    - Can't rob two adjacent houses
    - Can't rob the last house if we rob the first -> circle

    The idea here is, we can choose to rob a house, if we go down that path, evaluate the two next
   houses. So our base case changes, here, have a flag for whether the first house was used in our
   res. Then when we get to the last value, we don't consider the last value
*/