class Solution:
    def partitionLabels(self, s: str) -> List[int]:
        last = {}
        for i, c in enumerate(s):
            last[c] = i
        
        res = []
        start = 0
        end = 0
        for i, c in enumerate(s):
            end = max(end, last[c])
            if i == end:
                res.append(end - start + 1)
                start = i + 1

        return res
"""
Given a string, and we want to make substrings -> as many as possible
the rule is: characters can only belong to substring in that it must be uniquue and not present in other substrings
and example is: "affabc" => ["affa", "b", "c"]

the idea, is that 'a' and 'f' are repeated and so we group them together to avoid having to repeat them in other substrings

GOAL: find the length of those substrings and then return them as a list

Intuition:
we find a char and then look at other instances of where that char is
we know that first and lastt instance must be its own substring
so for each character, it has it's own partition.
if we know where each char ends, then we can group chars wiht overlapping partitions

trace:
x: 3
y: 4
z: 7
b: 9
i: 10
s: 11
l: 12

the idea is that as we go along thru the array, we can find the lenght fo the char that goes the furthers and then treat that as our stopping point for hte partition
say we only had x, and we was paring thru. Then we know as long as we don't have any chars, the the stoppinng point for x would be the vaalue we have in ouru hashmap
then we keep track of the length fo teh curren partion
"""

