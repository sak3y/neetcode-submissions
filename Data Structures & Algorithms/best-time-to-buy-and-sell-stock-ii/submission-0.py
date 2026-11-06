class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        memo = {}
        def dfs(i, isHold):
            if i == len(prices):
                return 0

            if (i, isHold) in memo:
                return memo[(i, isHold)]

            if isHold: # continue holding or sell
                sell = prices[i] + dfs(i + 1, False)
                hold = dfs(i + 1, True)

                res = max(sell, hold)

            else:
                buy = dfs(i + 1, True) - prices[i]
                skip = dfs(i + 1, False)

                res = max(buy, skip)

            memo[(i, isHold)] = res
            return res
        
        return dfs(0, False)


"""
    We can choose any day to buy a stock but we can't sell on the same Day.

    Early on we can decide whcih stocks are worht buying using a two pointer approach.
    We take a greedy approach, i.e we take the first instance where we are able to makke a profit so 
    that way, we have the chance to buy antother stock

    One idea is to sort, -> we lose the order of days (non-chronoligical).
    Obviously a greedy approach makes sense but we have to consider buying at one point and then selling at any other future day and not just the next instance we find a
    
    # we can choose to buy or skip
    # if we buy -> we can't buy again. So we have to either hold or sell
    # we keep track if we are holding: isHold
    # base case is if i is equal to len of the prices
"""