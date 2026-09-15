class Solution:
    def canJump(self, nums: List[int]) -> bool:
        memo = {}

        def dfs(i):
            if i in memo:
                return memo[i]
            if i >= len(nums) - 1:
                return True
            

            for n in range(1, nums[i] + 1):
                if dfs(n + i):
                    memo[i] = True
                    return memo[i]

            memo[i] = False
            return memo[i]

        return dfs(0)
                


"""
    so we can choose to jump, 1 to n, where n is the nums[i]\
    GOAL: reach the last index

    Because we have a series of choice at each stage.
    ANd not all paths guarnetee an outcome, we need to find the most optimal paths

    Since we only knwo the best path once we reach the end or past the end. 
    we cna work backwards

    recursivley, we can try every possible value to see what gives the optimal path
    then add in dp to save time

    implemntation:
    - sincw at any stage we cna make any choice.
    - use a for loop to traverse every value at nums[i]
    - then pass that into a recursive call
    - base case:
        if we land on a 0
        - contrainst are positive 
        - reaching last index or out of bounds means we are good
    
"""