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
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }
}


/*
    Look for a cycle in a linkedLIst
    Cycle => if at any point, a node can be revisited. We would say that's a cycle.
    Essentiatily and infinite pointer where the next pointer point to an existing node.
    The opposite is the case, when a pointer can point to null and we can be done parsing the list

    How do we deterimine a cycle?
    - If at some point the values start repeating, (and we keep track), then we know 
        well not really, in a really long list, values may repeat by chance so we can't use values to decide
    - what if we used two pointer
        a fast pointer and a slow pointer
        a slow pointer catching up to the fast indicates that we reached a loop right?

        how would we know that it reached a loop and they 
    
*/