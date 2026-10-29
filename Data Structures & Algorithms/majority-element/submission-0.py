class Solution:
    def majorityElement(self, nums: List[int]) -> int:

        count = defaultdict(int)
        for num in nums:
            count[num] += 1
        
        majority = len(nums) / 2
        for key, val in count.items():
            if val >= majority:
                return key

        return -1