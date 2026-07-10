class Solution {
    public int largestRectangleArea(int[] heights) {
        int res = heights[0];

        for (int l = 0; l < heights.length; l++) {
            int minHeight = heights[l];

            for (int r = l; r < heights.length; r++) {
                int width = r - l + 1;
                minHeight = Math.min(heights[r], minHeight);
                
                int area = width * minHeight;

                res = Math.max(res, area);
            }
        }
        return res;
    }
}
/*
    GOAL => Find a possible area where u can form a rectangle
    Get the biggest one

    Finding a biggest area:
    Area = W x H => Maximising both is how we get the largest value
    H => is dependant on the index, and say we have a list, we only take hte shortest one
    W => we can go up to the len of list but, we also need to determine what works for h

    A rectangle can be formed with only one height as well

    SOLUTION
    BRUTE FORCE
    - Two pointer solution, taking the smalest value as the height
    - Extending len to get width
    - Comparinh curr vs max

    O(n) Solution
    Using a stack, we push values in a monotonically decreasing order
    Take the top of the stack as the height since that's the max is goes anyways
    [7, 1, 7. 7, 2, 2, 4] => here past, i1, 1 becomes the limiting height

*/