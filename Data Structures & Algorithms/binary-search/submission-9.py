class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l, r = 0, len(nums) - 1

        while l <= r:
            mid = int(l + ((r - l) / 2))
            if target == nums[mid]:
                return mid
            elif target < nums[mid]:
                r = mid - 1
            else:
                l = mid + 1

        return -1   

"""
    Sorted array -> find target.
    If exsits: return index, else -1
    obviously there is the o(n) approach, which goes thru each index and then returns
    the values

    Binary search;
    since it's ordered, we can elimnate half the result if we start at hte mid point
    takes O(logn)
"""