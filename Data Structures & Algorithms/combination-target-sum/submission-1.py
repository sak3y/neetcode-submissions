class Solution:
    def combinationSum(self, nums: List[int], target: int) -> List[List[int]]:
        res = []
        def backtrack(i, combination, count):
            if i == len(nums) or count > target:
                return
            if target == count:
                res.append(combination.copy())
                return
            
            #add
            combination.append(nums[i])
            count += nums[i]
            backtrack(i, combination, count)

            #skip
            combination.pop()
            count -= nums[i]
            backtrack(i + 1, combination, count)

            return
        
        backtrack(0, [], 0)
        return res

"""
    Target -> form from nums
    - Must contain unique solution
    - Can use multiple elements more than once
    - condition is: as long as we are <= target, we can add any number

    - so at each stage, we have n number of elements to pick from
    - we can recursively build out lists, where we choose to either:
        - add element
        - skip element

    - base case:
        - sum > target: return
        - sum == target: add current lsit to res

"""