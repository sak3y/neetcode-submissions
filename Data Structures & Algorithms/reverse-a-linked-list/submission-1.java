/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
 

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}


/*
    GOAL => reverese the linked list











$0
    [0,1,2,3] => [3,2,1,0]

    EDGE CASES:
    - Empty list => return empty list

    How linked lists work.
    - Head is the start
    - Head = {value, pointer to next node}

    SOLUTION
    - Changing the direction of the pointer so instead of 0 => 1, 0 <= 1.
    - because this is a singly linked list, we can only ever move forward
    
    [0 -> 1 -> 2 -> 3]
     l    r
    
    [0 <- 1 -> 2 -> 3] ! say r should point ot left, set l to r and hten update r
          l    r 

   using a two list approach, update the first list by just 1, then redirect the pointer.next
   to the value sitting in the previous
*/