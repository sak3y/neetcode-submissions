class Solution {
    public int rob(int[] nums) {
        int prev1 = 0;
        int prev2 = 0;

        for (int num : nums) {
            int cur = Math.max((prev2 + num), prev1); // choose to rob house or not
            prev2 = prev1;
            prev1 = cur;
        }
        return prev1;
    }
}
/*
    [2,1,1,2]
    Can't pick two houses adjacent
    GOAL: return the max money we can rob
    Decision
    - we can choose to rob a house, our option become
    limited after that choice
    - So our choices are dependant
    - Picking a wrong choice means we go down the wrong 
    path until exhaustion
    - Greedy doesn't work either

    We can solve this recursively.
    When we pick a house, we take the two next houses
    evaluate which one gives us the highest results
    We run the dfs on the first two values
    We want to account for all possible values
    If we take hte max between each values, we end up with the best choice
*/