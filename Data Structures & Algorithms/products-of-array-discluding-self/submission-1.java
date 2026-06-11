class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int prod = 1;

            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    prod = prod * nums[j];
                }
            }
            res[i] = prod;
          
        }
        return res;
    }
}  

/*  
    Intuition:
    - For a value at i, we look at all other values and get their product
    - Two pointer solutions where l is at the index we want to find the product for and r is the numbers we want to multiply by\
    - Sol above is O(n^2)
    - O(n) solutions without using division -> if we could use division we could just find the net product and then divider by each number of the index 
    - that solutoins would be O(n) for the net product and then O(n) to divide which is O(2n) -> O(n)
    -  

    Solution:
    - two pointer have one that updates teh current index and the toher that goes over each value, getting the product
    and ignoring values at the index of where the other pointer is. Reset
    
    Edge Cases:
    - Whnever u have 0, then everything else become 0 except hte index of where that 0 is unless u have more than one 0
    - negative number are permitted but that doesn't affect us
    - product won't go over 32 bit integer so we don't have to worry about integer overflow
*/