class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        
        res = []
        def backtrack(i, subsets):
            if i >= len(nums):
                res.append(subsets.copy())
                return

            subsets.append(nums[i])
            backtrack(i + 1, subsets)

            subsets.remove(nums[i])
            backtrack(i + 1, subsets)

            return subsets
            
        backtrack(0, [])
        return res

"""
    We want to exhaust ever possible subset (non contigous)
    So for [1] -> [1], []

    BF:    
    we have set of number n
    we can choose whether to add a number or not 
    visualing as a binary tree.
    Each value has two options:
    and with the number of lemeent being n
    TC: O(n^2)

    Optimised
    - i believe bf is as fast as it goes
"""
    