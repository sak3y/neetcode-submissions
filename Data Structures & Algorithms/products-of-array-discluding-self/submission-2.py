class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        res = [1] * len(nums)

        prefix = 1
        for i in range(len(nums)):
            res[i] = prefix
            prefix *= nums[i]
        
        suffix = 1
        for i in range(len(nums) - 1, -1, -1):
            res[i] *= suffix
            suffix *= nums[i]


        return res


"""
    Given a list. We have to return a list where the index is 
    the product of all other elemnts besdies the element of the index
    that we are at

    so at idx 1, it's val will be idx 0 * idx 2 * idx...

    Brute force. 
    - we can solve this by using a nested loop and two pointer
    - get teh prodcts of all elements except for the one we are at
    - we move the pointer, and then parse the entire array
    - update our left pointer by 1 and reset the rigth pointer to 0
    - TC: O(n**2)

    Efficeint:
    - we could calculate the total products across all the list on a single pass
    - that way, we only need to divided by the current number to get the res: two passes means an O(n) solution

    oh shit, i forgot the edge case of 0


    new solution:
    - for a given index, we multiply everything on left by right
    [1,2,3,4]
    0 -> 2 * 3 * 4
    1 -> 1

"""