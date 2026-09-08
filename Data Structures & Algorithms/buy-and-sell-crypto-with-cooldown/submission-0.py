class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        memo = {}

        def dfs(b, hold):
            if b >= len(prices):
                return 0
            if (b, hold) in memo:
                return memo[(b, hold)]

            wait = dfs(b + 1, hold)
            
            if hold:
                # choose to sell or hold
                sell = prices[b] + dfs(b + 2, False)
                result = max(wait, sell)
                
            else:
                # choose to buy or not buy
                buy = -prices[b] + dfs(b + 1, True)
                result =  max(wait, buy)

            memo[(b, hold)] = result
            return result

        return dfs(0, False)



"""
    We can buy and sell multiple neetcoins throughout the day with cooldown of 1 day
    - we cant sell one day and buy again next day
    - we can only hold one neetcode at a time
    - whichver day we buy, we have to pay that price. meaning that we won't always be in a positive
    - we also don't want ot hold onto a coin for too long -> limit opportunity

    GOAL: max profit

    Brute force: 
    - on any given day we can choose to buy or not buy
    - and the day after if we are holding a neetcoin we cna choose to sell or to hold
        if we do sell, then we have to wait a day -> we want to sell as fast as possible

    - so it boilds down to a decision tree
    - we don't know what will give us the best profit in advance so we need to work recursively. 
    - so buy: sell or hold
    - don't buy: buy or dont buy
    - sell: skip a day
    - hold: go to next day

    SO WHAT'S THE SUBPROBLEM
    - we pick a day to buy
    - we pick a day to sell
    - the subproblme them becomes, what the btes twindow to buy and sell on the days
    after we sold.
    - recursively the problem becomes buy, pick any day to sell,
    on the days after we sold, + 1 more day, pick another day to buy adn sell
    - then we keep track of profits on all those chains
    - then we take max

    recursion solution
    - two decision at each stage
    - base case:
    - end of array when either sell or buy goes past len
    - if we hold, we can either sell next day or skip

"""