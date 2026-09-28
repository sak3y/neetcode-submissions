# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:    
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if not lists or len(lists) == 0:
            return None

        def mergeTwo(l1, l2):
            dummy = ListNode()
            cur = dummy

            while l1 and l2:
                if l1.val <= l2.val:
                    cur.next = l1
                    l1 = l1.next
                else:
                    cur.next = l2
                    l2 = l2.next
                cur = cur.next

            cur.next = l1 or l2
            return dummy.next

        # divide and conquer merge
        while len(lists) > 1:
            mergedList = []

            for i in range(0, len(lists), 2):
                l1 = lists[i]
                l2 = lists[i + 1] if i + 1 < len(lists) else None
                mergedList.append(mergeTwo(l1, l2))
            lists = mergedList

        return lists[0]
"""
    Given K linked list, that are in sorted order
    Combine them and return as a single linked list

    Intuition:
    - because sorted, we can use a two pointer approach
    - initializea our list wiht the smallest node
    - we can break this down into merge two linked list

    Merge two linked:
    - two pointer, and we make a new linked list
    - we would assess the smaller value at each head
    - once merged
    - we would then evalute the next list in our lists and merge it against the running res
    - repeat until that pointer is out of bounds

    tc = O(n*m) where n = number of node in a list and m is the number of linked lists

"""
