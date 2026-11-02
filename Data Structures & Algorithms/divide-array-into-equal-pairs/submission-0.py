class Solution:
    def divideArray(self, nums: List[int]) -> bool:
        count = defaultdict(int)
        for num in nums:
            count[num] += 1

        for c in count.values():
            if c % 2 != 0:
                return False

        return True


# we select a number
# see if a simialr number exists -> add it's index to a set
# TC: O(n**2)
# we can use a hashtable and add elemetns that way
# each intance in our hastabel should have an even count
# if any have odd return false