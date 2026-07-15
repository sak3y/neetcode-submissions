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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode res = new ListNode();
        ListNode tail = res;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            }
            else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        tail.next = (list1 == null) ? list2 : list1;

        return res.next;
    }
}

/*
    - Create a new list
    - Have pointers on both
    - Compare
        1 == 1
    - Add any doesn't matter: 1
    - Update pointer
    - Compare
        1 < 2
        Add 1: 1 -> 1
        update pointer
    - Compare:
        2 < 3
        Add 2: 1 -> 1 -> 2
        Update
    

    1 -> 2 -> 4
    1 -> 3 -> 5


*/