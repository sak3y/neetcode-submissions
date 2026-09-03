class Solution:
    def search(self, nums: List[int], target: int) -> int:
        def recur(l, r) -> int:
            if l > r:
                return -1

            mid = l + ((r - l) // 2)

            if target == nums[mid]:
                return mid
            if target < nums[mid]:
                return recur(l, mid - 1)
            else:
                return recur(mid + 1, r)
                
        return recur(0, len(nums) - 1)
            

"""
recursive approach
base case is when we l == r
or find target
sub problem
 we elimate 

"""