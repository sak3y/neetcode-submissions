class Solution {
    public int maxArea(int[] heights) {
        int max = 0;
        int l = 0;
        int r = heights.length - 1;

        while (l < r) {
            int curr = Math.min(heights[l], heights[r]) * (r - l);
            max = Math.max(curr, max);

            // The reason we have it this way is because we can't make full use out of the length of
            if (heights[l] < heights[r])
                l++;
            else
                r--;
        }

        return max;
    }
}

/*
    Idea:
    - Want to find the biggest area.
    - That means we find to find a value such that (i2 - i1) x heights[smaller i]
    - we take the smaller i unless they are equal because water would overflow otherwise
    - Since we take the smaller value, we don't care about the bigger values since the smaller
   values is used for calculation

    Edge cases:
    - for a heights of lenght 2, we just take th widht and height of the smaller value

    Solution:
    - Brute force, we run the above forumal using a two pointer taking the greatest value each
   time-> O(n^2)
    - intelligent solutions is ajdusting our pointers based on the heights. Pointer starts at each
   end and we calculate conditionlly

*/