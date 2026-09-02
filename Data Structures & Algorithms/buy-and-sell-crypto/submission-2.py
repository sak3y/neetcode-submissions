class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        res = 0

        for l in range(len(prices) - 1):
            for r in range (l + 1, len(prices)):
                profit = prices[r] - prices[l]
                res = max(res, profit)
                
        return res


"""
    - we can choose a day to buy and sell
    - the day we buy must be before the day we sell and it can't be the same day
    - we can also choose not to buy
    GOAL: maximum profit

    Brute force:
    - start left and the move our pointer right
    - we then take repeated maxes, by taking r - l.
    - we do that fro all values of r until len - 2

"""
