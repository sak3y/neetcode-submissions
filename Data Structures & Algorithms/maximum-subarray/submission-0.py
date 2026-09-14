class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        biggest = nums[0]
        rc = 0

        for num in nums:
            if rc < 0:
                rc = 0
            
            rc = rc + num
            biggest = max(biggest, rc)

        return biggest
        

"""
    GOAL: find the biggest subarray
    - we are given an array containing negative and positive numbers
    - subarray has to be connected
    - it can be of any length

    
    Brute force:
    - we test the size on an increasing window
    - we store their sizes and try and get the biggest one
    - windows -> can shift and change sizes
    - we can have ponter between both ends.
    - then recursivgelt slim down the windows by each side
    - calculat the sum and store it
    - 

    test: [4, -2, 3]
    we can have: 4, -2, 3, [4, -2], [-2, 3], [4, -2, 3] - thata n! number of subarrays

    we can't sort -> lose the order

    Solution: didnt' get it:
    - so we roughly know what paths may be good by determining hte running count
    - so long as that is positive, when we add a number to our rc, it should stay positive
    - if it doesn't, we know it's a bad number and we restart
    - this isn't necesrily a recursive problem but does deal with subproblems of tracking count as we move along
    

"""