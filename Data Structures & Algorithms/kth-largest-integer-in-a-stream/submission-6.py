class KthLargest:

    def __init__(self, k: int, nums: List[int]):
        self.minHeap = []
        self.k = k

        for num in nums:
            self.add(num)

    def add(self, val: int) -> int:
        heapq.heappush(self.minHeap, val)

        if len(self.minHeap) > self.k:
            heapq.heappop(self.minHeap)

        return self.minHeap[0]

"""
    Should 
    - Initialise an object that stores number
    - Have an add function that adds number to our obj

    The goal is to return the kth largest in an list.
    
    Brute force:
    - we would create an array
    - add numbers to that array
    - keep them sorted by running .sort everytime we add a number and return the kth larrgetst by idnexing backwards

    Optimised solution.
    We know that we only ever need k values.
    Each time we add, we don't want to sort as that
    would be slow, so a better approach was if we could
    add and have it go into teh correct spot
    A way to this is a max heap.

    We only ever store k values
    we pop the biggest values each titme we add and then return what we get since it's only k size, popping the biggest wouuld give us k
"""