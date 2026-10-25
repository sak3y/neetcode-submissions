class Solution:
    def maxCoins(self, nums: List[int]) -> int:
        nums = [1] + nums + [1]
        dp = {}

        def dfs(l, r):
            if l > r:
                return 0
            if (l, r) in dp:
                return dp[(l, r)]

            dp[(l, r)] = 0
            for i in range(l, r + 1):
                coins = nums[l - 1] * nums[i] * nums[r + 1]
                coins += dfs(l, i - 1) + dfs(i + 1, r)

                dp[(l, r)] = max(dp[(l, r)], coins)
            return dp[(l, r)]

        return dfs(1, len(nums) - 2)
            


"""
    Problem:
    - We have n number of balloons to choose from
    - when pop balloon, we get (i - 1), i, (i + 1) coins, where i represent a val in nums
    - when we pop a balloon, it's not longer in nums
    - we can assume that out of bounds would be 1 if i does go out
    - what order of balloons do we pop to get the most coins?

    GOAL: Max coins we can get

    Brute force:
    - we can choose to pop any balloon as we don't know in advance what would gives us the most coins
    - in nums we want to pop all balloons as that gives us a guarenteed way to get coins
    - so starting from i = 0
    - we have two choices
        pop
        not pop

    if we pop:
        take the left adn right value (default to 1 if they dont exits)
        and calcualte their product
        then remove that value

    Recursively, we cover all possible combinations
    TC: O(2^n)


    Issues:
    - when skipping a balloon, we have to come back and pop it anyways.
    
    SO, the number of balloons we pop is always N
    Order matters -> how do we traverse the order to get the best cost?
"""