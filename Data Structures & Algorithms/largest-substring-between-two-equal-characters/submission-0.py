class Solution:
    def maxLengthBetweenEqualCharacters(self, s: str) -> int:

        end = {}

        for i in range(len(s) - 1, -1, -1):
            c = s[i]
            if c in end:
                continue
            end[c] = i

        high = -1

        for j, c in enumerate(s):
            high = max(high, end[c] - j - 1)

        return high
