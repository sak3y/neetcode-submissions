class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map = {}

        for i, num in enumerate(nums):
            complement = target - num

            if complement in map:
                return [map[complement], i]
            
            map[num] = i

        return []

"""

    brute force is to use a 
    - nested loop
    - when both pointers aren't on the same index
    - we calculate their sum and return the indices if htey match to the traget

    Faster
    - we can store our values in a map
    - along with their indexes

    then we parse the orginal array and look for whether values exist
    in our map so that would be target - cur
    - since maps have fast lookup, 
    this would be less than O(n**2) more O(n)
"""