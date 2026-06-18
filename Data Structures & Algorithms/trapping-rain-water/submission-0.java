class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;

        int maxl = height[l];
        int maxr = height[r];

        int res = 0;

        while (l < r) {
            if (maxl < maxr) {
                l++;
                maxl = Math.max(maxl, height[l]);
                res += maxl - height[l];
            }
            else {
                r--;
                maxr = Math.max(maxr, height[r]);
                res += maxr - height[r];

            }
        }
        return res;

    }
}

/*
    - The idea is that the water has to fit between two heights
    - biggest area is betwen two swallest but we take the height of the smaller one
    - the idea is a two pointer solution that evaluates higher heigts
    - we then look at heights that are either equal to that higher height and then compare the area
   that that they can contain
    - formula that we use is the heights of the lower (if it's equal we take any)
    - tthen we take the disttance between them.
    Multiply l x h - (all values between that).
    We also got to bare in mind that there should be a space bettween them so we only ever look at a
   value like x then evaluate x +- 2
    - if two pointer is used, we only look at peak and any values between the must be less otherwise
   disregard
    - example: if have pointer's l and at both ends.
    that hieght would be 0 and 1. Since there exists peaks between them we move the pointer

*/