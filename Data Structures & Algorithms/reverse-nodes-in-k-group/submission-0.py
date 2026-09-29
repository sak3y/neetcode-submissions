# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        dummy = ListNode(0, head)
        prevGroup = dummy

   
        while True:
            kth = self.getK(prevGroup, k)
            if not kth:
                break
            nxtGroup = kth.next

            prev, cur = kth.next, prevGroup.next
            # reverse group
            while cur != nxtGroup:
                tmp = cur.next
                cur.next = prev
                prev = cur
                cur = tmp
             
            tmp = prevGroup.next
            prevGroup.next = kth
            prevGroup = tmp

        return dummy.next

    def getK(self, node, k):
        while node and k > 0:
            node=node.next
            k-=1

        return node

"""
    We have a series of nodes
    GOAL: Reverse the k number of nodes at a time, repeat until the end
    
    Rules
    -If there are less than k nodes left then ignore
    - We can't change values


    Subproblem: reverse a linked list
    - get to a null head -> we've reached end
    - (gonna have to update pointers) -> p(n - 1).next = p(n - 2) 
    - store the nodes?
        we can store each node in a list.
        then we say each previous node connect to the current

    - Or the pointer approach prev, cur, and next
    
    Putting it together.
    - we would need to keep track of the first node in the reversed (so the end node once reversed)
    - the next node would aslo the new reversed sub list
    - that four pointer

"""