class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        l = 0
        r = len(numbers) - 1

        while l < r:
            s = numbers[l]
            b = numbers[r]

            if s + b == target:
                return [l + 1, r + 1]
            elif s + b > target:
                r -= 1
            else:
                l += 1
        
        return []

""" 
MUST BE: O(1) SC

We are gien a sorted array
It's 1-indexed
Given a Target, return two values that sum to Target
t1 < t2
There is always one solution

Brute force
- limited on space,
- use a nested loop parse, through each value matching them up and then return the answer (two pointer)
- TC: O(n**2)

SOLUTION:
- We can use the fact that it's sorted to help narrow down the values
- first things tha comes to mind is binary search
- we can initalise pointers at the end, 
ask if the value sums up ot target
- if it does return
- if we find that the sum is greater, 
    ex, 4 + 1 > 3. then we need to go smaller so decerment r
- and vice-versa
"""