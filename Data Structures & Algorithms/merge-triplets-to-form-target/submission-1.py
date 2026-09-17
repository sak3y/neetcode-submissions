class Solution:
    def mergeTriplets(self, triplets: List[List[int]], target: List[int]) -> bool:
    
        res = [0, 0, 0]
        for triplet in triplets:
            a,b,c = triplet


            if a > target[0] or b > target[1] or c > target[2]:
                continue
            
            res[0] = max(res[0], a)
            res[1] = max(res[1], b)
            res[2] = max(res[2], c)


        return res == target
"""
    Given any array of triplets
    we can perfrom a single operaion 0 or more times on 2 different triplets
    GOAL: we want to get to the target by either finding an exisiing triplet or performing operations until we get there

    Inuition
    - we don't know the ideal path in advance
    - we do know the target, so it's simply doing the operations until 
    we get to target
    - we know that for an operation, we take the max between two values ac
    ross our triplets
    - brute force solution would try and match values at random until we get the target
        that would invovle using a two pointer solution 
    
    - so we have our function and we're trying to get the correct assortment of triplets, which is either 0 - many number of times
    however, when we perform the operation, one of tthe array gets' permanently updated

    - brute force
    - check if curr matches target
    - we check against three elements
    - as long as the max between one of the elements matches target we can perform teh operation
    - since we want to get closer to the result
    - then we would do that with another array
    - essentialy try out all possible triplets that improves our matchup

    recursion
    - at each hinstance we can chose to perfrom a calculation on a pair
    - that covers all possible decisions

    Greedy
    - for an optimal choice, we pick triplets where all values are less then the target
    - that way when we perform operations, we still have a chance of 
    reaching target
    - then we do operations on every triplet so long as they follow that rule, and eventually, they will align """