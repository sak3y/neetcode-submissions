class Solution:
    def minOperations(self, nums: List[int]) -> int:
        flips = 0

        for i in range(len(nums)  - 2):
            cur = nums[i]

            if cur == 0:
                # have to flip
                flips += 1
                for j in range(i, i + 3):
                    nums[j] ^= 1
        return flips if nums[-1] == nums[-2] == 1 else -1


# a chosen elemnt, we must fli both it's left and right values 
# goal is to make every entry 1s
# ideal condition is three adjacent 0s
# however we could have a where we flip an entyr ocntaining a 1
# and then later flip it to get a better results
# i've fucking figured it out
# if the first diti is a 0, there is only one possible way to flip it since we have to do consecutive values
# so thet's forced move -> the next value. There are two possible ways to flip it but sicne we were forced to flip the first one (if it was 0), that means there is only one possible move so again
# we are forced to use that move
# when we get the the third values
# therefore, we only ever get one  choice if we do choose to flip
# and we want to keep track of all 1s on the left