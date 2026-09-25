class Solution:
    def reverseBits(self, n: int) -> int:
        res = 0
        for i in range(32):
            bit = n & 1 # gets the first bit
            res = res << 1 | bit # two things: shifts then ors bit
            n >>= 1
        return res


"""
reverse the unsigned version of the binary rep of n
so from forwards -> backwards

would use a for loop and 

Implementation
using the bit move
evaluate number at the end.
Then add that number to the start 

if there is a way to move from right to left in a 
"""