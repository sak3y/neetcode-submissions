class Solution:
    def containsNearbyDuplicate(self, nums: List[int], k: int) -> bool:
        index = defaultdict(list) # num : [idx1,idx2...]
        for i, num in enumerate(nums):
            index[num].append(i)

        for arr in index.values():
            if len(arr) < 2:
                continue
            
            for i in range(1, len(arr)):
                if abs(arr[i] - arr[i - 1]) <= k:
                    return True

        return False
            
"""
    i == j
    and the difference is less then k
    ex1
    k = 3

    0,1,2,3
    1,2,3,1

    3 - 0 <= 3
    
    1st:
    find duplicate pairs
    map : [indexes]

    2nd:
    find pairs that fall below k
    we could sort out indexes array - Omlogm
    we could brute force check it - O(m^2)
"""