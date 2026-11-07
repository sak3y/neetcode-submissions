class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        count = {0: 1}
        cur = 0
        res = 0

        for num in nums:
            cur += num

            res += count.get(cur - k, 0)

            count[cur] = count.get(cur, 0) + 1

        return res