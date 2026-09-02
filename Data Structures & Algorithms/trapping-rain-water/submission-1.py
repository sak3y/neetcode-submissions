class Solution:
    def trap(self, height: List[int]) -> int:
        if not height:
            return 0

        l, r = 0, len(height) - 1
        maxLeft, maxRight = height[l], height[r]
        res = 0

        while l < r:
            if maxLeft < maxRight:
                l += 1
                maxLeft = max(maxLeft, height[l])
                res += maxLeft - height[l]
            else:
                r -= 1
                maxRight = max(maxRight, height[r])
                res += maxRight - height[r]
                
        return res
"""
    Total heights that can be stuck between a bar:
    - has to have an edge on the left > 1
    - an edge on the right > 1
    - anything left of the first side can't trap anything
    - same goes for the right side
    - idea:
        we know that water to be place:
        there has to be a gap between two edges. so while they are adjacent, water cannot exists
        - so a gap of at least1 is required
        - we also know that the edges must be at least 1 tall
        - how do we calculate the water then?
        - well we know that the water goes only up till the shorter side so we take the smaller height
        - we then trace thet distance between them, that would be the 
        difference in index
        - we also know that block may exist there which messes up our
        volume placement.
        - taking the blocks in that space and then subtract that from tthe the widht * height

    putting it together
    we know that for a side to be valid and be able to hold water,
    it has to:
    - have a gap
    - eventually have a side that is greater then or equal to the first side
    - when we get to a side, it has to be the tallest out adjacent blocks.

    implemetation
    - using a two pointer approahc, we get the peak and the next peak. 
    - between those tow peaks, we are able to 

    - actualt solution
    - we can look at the values of water at each index, 
    depening on the left and right peaks.
    - we take the lowest of those heights and then go that heigh
    - using a
"""