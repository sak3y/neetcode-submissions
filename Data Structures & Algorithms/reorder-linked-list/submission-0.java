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
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        // Reach middle node
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;
        ListNode prev = null;
        slow.next = null;
        // reverse second linked list
        while (second != null) {
            ListNode tmp = second.next;
            second.next = prev;
            prev = second;
            second = tmp;
        }

        // Combine first and second list in new list
        ListNode first = head;
        second = prev;
        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;
            first.next = second;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
    }
}


/*
    GOAL => Convert a list initally as: {1,2,3,4,5} to {1,5,2,4,3}

    CONSTRAINTS
    - Can't change the values
    - Have to use a singly linked list

    BRUTE FORCE SOLUTIONS
    t

    Optimised
    - take first half of the list
    - take second half of the list
    - store them seperately
    - reverse the list that holds the second part
    - Combine the two lists (zigzat) using a temp list to hold heads values at different stages
    - return
*/