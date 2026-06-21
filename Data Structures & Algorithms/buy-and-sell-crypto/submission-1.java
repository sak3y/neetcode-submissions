class Solution {
    public int maxProfit(int[] prices) {
       int lowest = prices[0];
       int profit = 0;
       int currProf; 

       for (int i = 1; i < prices.length; i++) {
            currProf = prices[i] - lowest;
            lowest = Math.min(lowest, prices[i]);
            profit = Math.max(profit, currProf);
       }

       return profit;
    }
}

/*
    Idea:
    - principle is buy low sell high -> min maxing which means looking at all possible values and selling
    - two pointer but the sell must be ahead of the buy so l < j
    - arrays wouldnt work because we need to preserve the order
    - using two pointe rna progressive moves -> O(n^2) -> how do we get an O(n) solution
    - 
   

    Edge cases:
    - if values are the same then we get 0
    - if all values are in decending order then the we have to sell at a loss. but if htat' sthe case we deafult to 0
*/