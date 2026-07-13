class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Integer.MIN_VALUE;

        for (int b : piles) {
            r = Math.max(r, b);
        }

        int res = r;
        while (l <= r) {
            int k = (r + l) / 2;
            int total = 0;

            for (int b : piles) {
                total += (b + k - 1) / k; // how many piles eaten at rate k
            }
            // Too slow to eat
            if (total > h) {
                l = k + 1;
            } 
            else {
                r = k - 1;
                res = k;
            }
        }
        return res;
    }
}

/*
    INTUITION
    H => TIME LIMIT
    K => RATE OF EATING PER HOUR 
    EACH INDEX => TAKES A MINIMUM OF AT LEAST 1K TO EAT (DEPENDING ON K).

    AT K = 2, AND N OF BANANAS AT 4, IT WOULD TAKE 2 HOURS. AT K = 1, IT WOULD TAKE 4 HOURS

    GOAL => IS TO FIDN THE SMALLEST VALUE OF K SUCH THAT KOK CAN EAT ALL THE BANANAS IN UNDER H HOURS.

    THE MINIMUM NUMBER OF HOURS IS ALWAYS GOING TO BE THE SAME AS THE LENGTH OF THE LIST SINCE EACH PILE TAKES 
    MINIMU ONE HOUR


    BRUTE FORCE

    IF WE START AT K = 1. AND THEN FIGURE OUT HOW LONG EACH STACK TAKES => WE CAN THEN INCREMENT UNTIL WE FIND A VALUE
    OF K WHERE IT'S POSSIBLE TO EAT ALL THE BANANS IN UNDER H HOURS

    
    OPTIMISED
    WE KNOW THAT WHEN 2 GOES INTO 1 FOR EXAMPES, THAT THE LEFT OVER IS 1. ESSENTAITLY THAT WASTE. WE WOULD GET THE SAME RATE
    FOR EXMAPLEIF WE USED 1 BECAUSE 
    1 => 1 ONCE
    2 => 1 ONCE AS WELL

    LOOKIGN AT A MORE OPTIMAL SOLUTION => WE WOULD USE VALUES THAT ARE ALREADY OUR LIST. EXAMPLE 4 GOES INTO 4 ONCE
    4 GOES ITNO 23 6 TIMES AND SO ON.

    THEREFORE THE OPTIMAL SOLUTION LIES WITHIN OUR ARRAY

    HOW DO WE FIND THAT OPTIMAL SOLUTION?

    LINEAR SEARCH => O(N) + TRYING DOING THE CALCULATIONS

    BINARY SEARCH => SORT (O(LOGN)) + TO FIND (O(LOGN)) => CALCULATIONS

    [4, 10, 23, 25] => does 10 works? [1, 1, 3, 3] = 8 => < h(4) => doesnt work, need to try something bigger
     l   m       r
    
    [4, 10, 23, 25] => does 23 work? [1, 1, 1, 2] => 5 > 4 => doesn't work, need to try another solution
        l    m   r


    IMPLEMENTATION
    1. SORT THE ALGO
    2. USE A 2 POINTER APPROACH TO TRY VALUES
    3. IF WE DON'T MAKE IT IN TIME I.E WE EXCEED H, THEN WE GO LEFT AND VICE-VERSA


    Max possible value (assuming that there is an answer) is max of piles
    smallest is 1.

    Searching between those two values.

    Too slow => adjust pointer => need biger k => replace l
    Too fast => adjust pointer => solution may be valid => adjust anyways so replace r.

    Keep track of current smallest and overall smallest. Once l == r, we can end and should have our resutls
*/