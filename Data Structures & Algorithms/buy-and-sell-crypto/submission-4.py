class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        l, r = 0, 1
        res = 0

        while r < len(prices):
            if prices[l] < prices[r]:
                profit = prices[r] - prices[l]
                res = max(res, profit)

            else:
                l = r
            r += 1

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

    optimsed:
    - instead we can use a two pointer soluiotn
    - we know that buy < sell:
    then we want ot get the profit
    - otherise, we found a cheaper prices and should update r

"""
