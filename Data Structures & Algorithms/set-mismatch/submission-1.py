class Solution:
    def findErrorNums(self, nums: List[int]) -> List[int]:
        count = {}
        for num in nums:
            if num in count:
                count[num] += 1
            else:
                count[num] = 1

        dupe = -1
        missing = -1
        
        for i in range(1, len(nums) + 1):
            
            if i not in count:
                missing = i
            if i in count and count[i] > 1:
                dupe = i

        return [dupe, missing]