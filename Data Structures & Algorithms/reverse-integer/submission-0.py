class Solution:
    def reverse(self, x: int) -> int:
        sign = -1 if x < 0 else 1
        rev = str(abs(x))

        new = ""
        for i in range(len(rev) - 1, -1, -1):
            new += rev[i]

        new = int(new) * sign
        
        if new > 2**31 or new < (-2**31 - 1):
            return 0

        return new

"""
    signed -> postive and negative
    
    1. Reverse 
    2. if it falls outside the range 2^31 and 2^31 - 1

    Approach:
    1. Reverse:
        Convert to a string
        parse backwards
        convert back to int
    
    2. If loops
    where x is the reversed number
    x <= 2^31
    x >= -2^31 - 1
    return 0 if x is outside

    TC: O(n) to parse the integers, then compare values so overal O(n)

    Optimsations:
    1. Finding a better way to reverse
"""