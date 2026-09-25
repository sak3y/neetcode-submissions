class Solution:
    def hammingWeight(self, n: int) -> int:
        binary = bin(n)[2:]
        res = 0
        for b in binary:
            if b == '0':
                continue
            res += 1
        return res

"""
Unsigned -> 31 bits for an interger from 0 - 2^32 - 1

we know that a number is made up of bits and the biggest number we can have is 213783657

my thiking is that if we peform an and operator on het two numbers
"""