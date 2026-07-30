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
        if (head == null) return head;

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
    reverse a list

    linked list all point in one direction with no going back (singly)
    to reverse a list we essentialy need to reverse the pointer of each node

    EX. the seconde node's pointer must be pointing towards the first node.
    we also need to be able to traverse the rest of the list

    Thus a three pointer solution would make sense

    an initial pointer at the previous node which we want to point Towards
    a pointer at the node whose pointer we want to change
    Another pointer that allows us to traverse the rest of the linked list
*/