# The guess API is already defined for you.
# @param num, your guess
# @return -1 if num is higher than the picked number
#          1 if num is lower than the picked number
#          otherwise return 0
# def guess(num: int) -> int:

class Solution:
    def guessNumber(self, n: int) -> int:
        l, r = 1, n

        while l <= r:
            mid = (r + l) // 2
            pos = guess(mid)

            if pos == 0:
                return mid

            elif pos == 1:
                l = mid + 1

            elif pos == -1:
                r = mid - 1
                
        return -1

            


# binary search -> given a 