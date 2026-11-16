class Solution:
    def rotate(self, nums: List[int], k: int) -> None:
        k = k % len(nums)
        l, r = 0, len(nums) - 1

        # 1st reversal
        while l < r:
            nums[l], nums[r] = nums[r], nums[l]
            l +=1
            r -= 1

        # 2nd reversal. K = partition point
        l, r = 0, k - 1
        while l < r:
            nums[l], nums[r] = nums[r], nums[l]
            l += 1
            r -= 1
        
        # 3rd reversal
        l, r = k, len(nums) - 1
        while l < r:
            nums[l], nums[r] = nums[r], nums[l]
            l += 1
            r -= 1
        


'''
    We tried doinghte rollover method linear, but that does't work instead, we need to figure out hwo to do it in O(1)

    there a special trick with reversal.
    if we reverse the array we end up with two paritions

    we know that for a certain range, values have roll back to the start
    that value is after n - k.
    when we do our reversal, that stays intace, we have two paritions but this time, the values are in theh correct area, njust they have been reversed
    so we need ot reverseindiduao partitoins to get the res
'''        