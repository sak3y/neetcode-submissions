class Solution:
    def getSum(self, a: int, b: int) -> int:
        carry = 0
        res = 0
        mask = 0xFFFFFFFF

        for i in range(32):
            a_bit = (a >> i) & 1
            b_bit = (b >> i) & 1
            cur_bit = a_bit ^ b_bit ^ carry
            carry = (a_bit + b_bit + carry) >= 2
            if cur_bit:
                res |= 1 << i

        if res > 0x7FFFFFFF:
            res = ~(res ^ mask)

        return res


""" 
to sum an integer:
- Assume: there is no mathmatic way to get to a + b without using + or -
- Prime numbers -> which we can't multiply to get to or divide

100
111

1011

Forgot to add carry

addition but we can use flags instead
10 -> 1
01 -> 0
11 -> 10
00 -> 00

note that 11 is the only instance were we put in two number

considering integers of different binary lenghts. On finishin noe number we can't do any more additon so we append hte rest of hte binary thin


"""
