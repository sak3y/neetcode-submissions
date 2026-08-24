class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        for (int i = len - 3; i >= 0; i--) {
            int first = cost[i + 2];
            int second = cost[i + 1];

            cost[i] += Math.min(first, second);
        }
        return Math.min(cost[0], cost[1]);
    }
}


/*
    We cna choose our startng point to be the first or second step
    From there we can move 1 or 2 steps ups
    The step we are at has a cost that we need to pay if we want to go higher
    GOAL: find the min cost to get the top step just after the last index in cost

    We need to make a decision
    1 or 2 steps
    
    Implementation
    - We know that this can be broken down into a subproblem
    - For list one, step 1
    - For a list of 2, the cheapest would be to either pay the cheaper cost betwee 1 and 2
    - For a list of 3, 

    We can work backwards, because our solutoin only involces three elemetns at a time, 
    we can make our subproblem the cheapest to get to the current elemetn from the prev
    ious two.
    - That works because we are calculating the cheaper cost at each iteration
    - In the event that we get two equal values, we take the one furhter away as it 
    allows us to make more jumps
*/