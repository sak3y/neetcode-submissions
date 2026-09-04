class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        memo = {}

        def dp(left):
            if left == 0:
                return 0
            # here, instead of doing all the recursion again, we check if value is computed and add it in
            if left in memo:
                return memo[left]

            res = 1e9
            for coin in coins:
                if left - coin >= 0:
                    res = min(res, 1 + dp(left - coin))
                
            memo[left] = res
            return res
            
        lowest = dp(amount)

        if lowest >= 1e9:
            return -1
        else: 
            return lowest

"""
    breaking down recursion
    - for the values in coin we want to see if they can get us to value
    so what do we do, we use the remainder value
    at each stage, we can decide to take away any coins from the target
    - if we haven't reached 0 yet then we can contiue our decision aka recur
    - if we have reached 0, we have a valid sequence. we'll compre this

    - if we go below 0, then we disregard
    We have an infinite numbers of a specific coint, could be 1, 5, 7 ...
    GOAL: to find the target amount by adding together any of the values in our 
    wallet. And return the QUICKEST / smallest way to do this
    The catch is, we can keep picking any value, any amount of times from the
    wallet


    The brute force, 
    since we want to get to target using as little coins as possible, 
    - we use the biggest number under the target
    - then we check what other values we can use
    - then use the biggest from those values and so on
    - and then we see if it's possible. if not we tryn a differnt values (more depth)
    

    Issues:
    - Do we know if a sequence of coins exists that sum to target -> going infinite
    - The specific selection that we choose (currently we are going biggest but is that sequence always one that works)
    

    BFS:
    - we want the first instace that gives us our target. 
    - BFS worsk because we it's level by level search
    - we see each val in our coins as decision in a decision tree
    - we then make a tree that recursievely maps values and then a bfs that checks if our value exists
    - we return the first instance of that
    - The TC of that is O(n**m) which is definetly not viable
    - the binary tree obiously has a lot of repeated calculations so we use dp
"""