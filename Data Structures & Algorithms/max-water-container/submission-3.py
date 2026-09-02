class Solution:
    def maxArea(self, heights: List[int]) -> int:
        l,r = 0, len(heights) - 1

        res = 0
        while l < r:
            vol = min(heights[l], heights[r]) * (r - l)

            res = max(res, vol)
            if heights[l] <= heights[r]:
                l += 1
            else:
                r -= 1

        return res
            



"""
    - Pick two sides that lets us store the most water
    - intuiton
        We could pick any height
        the volume that gives us is the height of the smaller one * the difference in position

        Brute force idea 
        - we pick sides from bothe ends. we calc
        the volume and then store that value
        - we update that value anytime we find a 
        larger volume
        - how do we actually find the correct heightt?
        - well we can intelligently update our pointer, since we know that the limit is the smaller side, we take that as our lenght
        so our l and r pointer, we update, taking math.max as we go along
        - edge cases? we don't really have any
        - TC: O(n)

"""