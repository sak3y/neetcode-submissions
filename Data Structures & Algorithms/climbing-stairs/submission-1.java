class Solution {
    public int climbStairs(int n) {
        if (n <= 2) return n;

        int prev = 1;
        int curr = 2;

        for (int i = 3; i <= n; i++) {
            int next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }
}

/*
    Need to climb stairs
    Can be done with either 2 or 1 steps

    GOAL: FIND THE DISTINCT NUMBER OF WAYS THE STAIRS CAN BE CLIMBED

    Pattern
    1: 1
    2: 2
    3: 3
    4:  1x1x1x1
        1x1x2
        2x1x1
        1x2x1
        2x2
       5
    5: 8

    Fibonnaci sequence right?
    Essentaitly we take n, and n-1. Given that they are at the start of the sequence. Sum them together.

    DP: Recursive
    base case: 1 and 2,
    recursively call sum of previous 2 numbers

    ISSUE: the method perfroms badly for large n values
    Because at n = 30, we are calling 29 and 28, which, then have their own two call. So the solution ends up being 2**n

    If there is a way to do this bottom up instead of recursively, that way, we don't have to recompute values and make uncessary function calls

*/