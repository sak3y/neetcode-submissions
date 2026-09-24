class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 0 or x == 1:
            return 1

        if x == 0: 
            return 0
        
        if x == -1: # we flip the sign, each time
            if n % 2 == 0:
                return 1
            return -1

        # very large negative number
        
        res = x
        if n > 0:
            for i in range(n - 1):
                res *= x

        if n < 0:
            for i in range(n, 1):
                if res < 0.000001:
                    return 0
                res /= x

        return res


"""
Given a fp number x

GOAL: return the x to the power of n,
where res = x * x * x * x ... n times

Forgot:
Edge cases:
n == 0
n < 0

when n > 0, we multiple by x
when n == 0, we get 1, since it's division
when n < 0, we divide

This questions a whole bunch of edge cases and we need to consider interger overflow too

an integer to the power of a very large negative number approaches 0
"""