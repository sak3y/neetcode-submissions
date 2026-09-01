class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        numSet = set(nums)
        longest = 0

        for num in numSet:
            if num - 1 not in numSet:
                length = 1
                while num + length in numSet:
                    length += 1
                longest = max(longest, length)

        return longest

"""

    find start of chain -> add our values to a map / set -> 
    check to see if values + 1 exist, nicrement count
    - we want to return thelongest consecutive sequence of number
    - their positions doesn't matter so long as we can from a chain
    - TC has to be O(n)

    Brute force
    - we could sort the array, then we would get our values toge
    ther but that would be O(nlogn)

    - i was thinking tthat we could pick the largest element, then we create an array with lenth as that element
    - then we would place number into their index rep
    - then we would have an array and we parse it and keep of 
    how long we can go without resetting
    TC: O(3n)

    Hashmap solution
    - we could parse the array and look for the start of a sequence. that way we only need to observe the chain up
    - To do so, there must not exists a number smaller than it
    - We could add our values to a map. Parse over the string, and then store those values in a list by asking does our map contain anything 1 less that this value?
    - no we have a list of start of chains.
    - then we go through our map, and ask does. value of 1 + curr exist, if it does, we increment oru curr max by 1.
    Take the largest of these chains
    
"""