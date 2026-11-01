class Solution:
    def sortColors(self, nums: List[int]) -> None:
        for i in range(len(nums)):
            idx = i
            for j in range(i + 1, len(nums)):
                if nums[idx] > nums[j]:
                    nums[idx], nums[j] = nums[j], nums[idx]

        """
        Do not return anything, modify nums in-place instead.
        Could use bubble sort -> in place but tc; o(n^2)
        merge sort is quicker -> not sre it it's in place

        so options are for logn tc:
        - timsort
        - quicksort

        slower algo:
        - selection sort:
        we divide array into sorted : unsorted
        we set first el as the sorted portion
        iterate over until we find smallest and swap with sorted portion
        go to next el. Repeat on the next portoin
        """
        