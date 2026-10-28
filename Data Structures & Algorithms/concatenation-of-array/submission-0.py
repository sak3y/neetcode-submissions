class Solution:
    def getConcatenation(self, nums: List[int]) -> List[int]:
        ans = [num for num in nums]

        for num in nums:
            ans.append(num)

        return ans

"""
    Given an array nums of len n
    we have to:
    - make an array of len 2n (call it: 'ans')
    - were ans[i] == nums[i]
    - and ans[i + n] = nums[i]


    Brute force 
    - So from 0 to n - 1, the number are the same as nums
    - then from n to 2n - 1 it's the same as before
    - we use 2 loops to copy values from nums to ans
    - then the second loop would parse over nums and add the same set of values


"""