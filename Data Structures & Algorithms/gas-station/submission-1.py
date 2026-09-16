class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        if sum(gas) - sum(cost) < 0:
            return -1

        total = 0
        res = 0
        for i in range(len(gas)):
            total += gas[i] - cost[i]

            if total < 0:
                total = 0
                res = i + 1

        return res


"""
    we can start at any station
    GOAL: to complete a circuit -> return the start that's valid
    assume -> we can only go one station at a time

    every statiion has a gas: ammount and a cost: gas to get to next
    so gas[i] - cost[i] is the remaining gas

    intuition:
    the idea is that any position could be valid so we try all of them
    valid -> we can cycle back to one of the position withoutt our gas reaching 0

    brutte force:
    - using bfs, we can say how many valid posittion can we reach such thatt we have gas left over
    - 
    
    edge case: since we can loop around, once we go outt of bounds, we need to reset

    two pointer solution:
    for an given index, the current position must be valid so we must have a least 0 gas in the tank by them time we arrive to the next station
    - so we use a curr and next and see if we can make it. curr will sore our starting posiion, and next would incrememnt so long as we have enough gas o make it to the next staion
    - do that until we reach start
    tc: O(n**2)
"""