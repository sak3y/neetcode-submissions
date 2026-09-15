class Solution:
    def jump(self, nums: List[int]) -> int:
        memo = {}

        def dfs(i):
            if i >= len(nums) - 1:
                return 0
            if i in memo:
                return memo[i]

            memo[i] = 9999
            for n in range(1, nums[i] + 1):
                jump = 1 + dfs(i + n)
                memo[i] = min(memo[i], jump)
                

            return memo[i]
        
        return dfs(0)

            

"""

similar to the previous game but we keep track of numbers
so instead of passing true or false, we recurse backwards and aks how many times did we jump
"""