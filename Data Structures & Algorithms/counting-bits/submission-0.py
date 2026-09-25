class Solution:
    def countBits(self, n: int) -> List[int]:
        res = []
        for x in range(n + 1):
            bits = 0
            while x:
                bits += x % 2
                x = x >> 1
            res.append(bits)
        return res

""" 
    two find a number 1, we can just get the modulus of a number. then shift it bitwsie to the rgiht and hten stor ethatn number
"""
