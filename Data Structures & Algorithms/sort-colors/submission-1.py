class Solution:
    def sortColors(self, nums: List[int]) -> None:
        count = [0] * 3
        for num in nums:
            count[num] += 1

        idx = 0
        for i in range(3):
            while count[i]:
                count[i] -= 1
                nums[idx] = i
                idx +=1 
            
            

        """
        Do not return anything, modify nums in-place instead.
        Could use bubble sort -> in place but tc; o(n^2)
        merge sort is quicker -> not sre it it's in place

        so options are for logn tc:
        - timsort
        - quicksort
        - heapsort

        """
        