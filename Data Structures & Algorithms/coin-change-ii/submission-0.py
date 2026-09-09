class Solution:
    def change(self, amount: int, coins: List[int]) -> int:
        memo = {}

        def dfs(i, total):
            if total > amount or i >= len(coins):
                return 0
            if total == amount:
                return 1
            if (i, total) in memo:
                return memo[(i, total)]

            take = dfs(i, total + coins[i])
            skip = dfs(i + 1, total)

            memo[(i, total)] = take + skip

            return take + skip
        
        return dfs(0, 0)
"""
    Given a number Target
    we have a list of coints in our wallet, suppose we have an infinite
    number of those coints.

    GOAL: to return all possible ways we can reach the target, by
    using all the values form our wallet

    - We can use coins multiple times
    - If we can't get to that target, then return 0
    - there are multiple ways of reaching the same path
        -> return unique paths

    Solution (Brute force):
    - since we can pick the first coin
    - since the coins doesn't get used.
    - we have the same selection of coins as we did at the start
    - this can be represented as a decision tree
    - so any decision that gives us less than or equal to the target is
    a valid path that we can consider.
    - recusrivly form all branches that match those conditions
    - run dfs on all the values were target is found, incrememtn count 
    - consider optimisations

    DP
    - Since there r a lot of repeated calculation when we decided to use a new coin, we can store and call it


"""