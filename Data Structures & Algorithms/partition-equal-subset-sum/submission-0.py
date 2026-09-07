class Solution:
    def canPartition(self, nums: List[int]) -> bool:
        if sum(nums) % 2:
            return False
        
        
        dp = set()
        dp.add(0)
        target = sum(nums) // 2

        for i in range(len(nums) - 1, -1, -1):
            nextDP = set()
            for t in dp:
                nextDP.add(t)
                nextDP.add(t + nums[i])

            dp = nextDP
        return True if target in dp else False

        

"""
    - we are able to pick any numbers
    - so long as we can make it equal
    - duplicate numbers -> make a two subsets
    - values for a subset 1 can't be used for subset two

    = Possible solutions
    - we sort the array
    - misunderstood the questions. It's not saying pick 2 subsets, 
    the remaining subset is the one leftover after we create the first one which encompass
    es every other element

    - brute force solution
    - make subsets, grow it each time. then check values remaining and cacl their sum
    - values we choose, add to subset 1 count
    - values we don't add to susbet 2 count
    - once we finidh the loop, we compare values and then return true if they match
    
    optimisations
    - we add in memo to store values
"""