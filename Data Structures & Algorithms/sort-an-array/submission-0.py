class Solution:
    def sortArray(self, nums: List[int]) -> List[int]:
    
        def mergeSort(nums):
            if len(nums) <= 1:
                return nums

            mid = len(nums) // 2

            left = mergeSort(nums[:mid])
            right = mergeSort(nums[mid:])

            res = []
            i, j = 0, 0

            while i < len(left) and j < len(right):
                if left[i] <= right[j]:
                    res.append(left[i])
                    i += 1

                else:
                    res.append(right[j])
                    j += 1

            res.extend(left[i:])
            res.extend(right[j:])
            
            return res

        return mergeSort(nums)


"""
    There are a couple ways to do this:
    - Quick sort
    - Merge sort
    - Timsort

    Merge sort is the simplest and is avg O(nlog(n)) across TC so I'll pick that
    
    Conceptually, we divide-and-conquer the array, split each element into it's own 'array'
    and hten compare values within those arrays bottom-up.
    That way, we are only comparing few elements at each array. So gradually, the more levels 
    we iterate up, teh more sorted our array becomes
    
    TC: O(nlog(n))
    SC: O(n)

    Solution
    - We use recursion to split up the array into it's elements
    - we then use a loop to compare values at the bottom level
    - then we add thsoe elments, smallest first, ot the list
    - 
"""