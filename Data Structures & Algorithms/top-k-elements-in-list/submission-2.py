class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count = {}
        for num in nums:
            count[num] = 1 + count.get(num, 0)

        minHeap = []
        for num in count.keys():
            heapq.heappush(minHeap, (count[num], num))
            if len(minHeap) > k:
                heapq.heappop(minHeap)

        res = []
        for i in range(k):
            res.append(heapq.heappop(minHeap)[1])
        return res

        
    
"""
    minHeap solution
    - we initilase the hashmap for values and as we do so,
    insert the  2d array into our hahsmap
    - since we only need k values, we insert until we reach that value
    - we then pop once reaching size whcih ensure we get rid of the smaller values leaving us with the k most frequent

"""