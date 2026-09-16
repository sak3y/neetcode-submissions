class Solution:
    def isNStraightHand(self, hand: List[int], groupSize: int) -> bool:
        if len(hand) % groupSize != 0:
            return False

        count = {}
        for num in hand:
            count[num] = count.get(num, 0) + 1

        hand.sort()

        for num in hand:
            if count[num] == 0:
                continue
            
            for nxt in range(num, num + groupSize):
                if count.get(nxt, 0) == 0:
                    return False
                count[nxt] -= 1
        
        return True

"""
     can split cards up into groups of size groupSize
     GOAL: determine whether we can split up the cards into groups so that they
     are consecutive

     assumptions
     that the length is divisble by group size so that all cards can belong to a group
     group size is less than the length of hand

    we create groups fro each new number we cross.

    we want to find number that are at the start of a group. that way the condition becomes number 1 greater then, we add that to the set greedily. 

    another approach:
    we can sort the list so that we can get the start of a group at the start
    then we take the first number, and then create our group
    we keep track of numbers that we've added to our initial group
    then we look at the next number that hasn't been added.
    try to make a group that way
    repeat until we all elements have been looked at
    tc: o(n) 

    implemntation
    we add an inital number into our map once sorted. then inside that map value for the first int, we have a list of values that link on to the original and are = to group size

    inintal num -> [map of consecutive numbers and their positions]
    adding a new initial num:
        - we check that it doesn't already exist in our map
        - hasn't been added as a sequence to our inital map
        - """