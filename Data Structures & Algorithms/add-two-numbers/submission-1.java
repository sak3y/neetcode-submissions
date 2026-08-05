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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int v1 = (l1 != null) ? l1.val : 0;
            int v2 = (l2 != null) ? l2.val : 0;

            int sum = v1 + v2 + carry;

            carry = sum / 10; // gives us the end digit
            sum = sum % 10; // gives the first digit

            cur.next = new ListNode(sum);

            cur = cur.next;
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        return dummy.next;
    }
}


/*
    To add two numbers, we simply need to add their respective digits
    this is made easier by the fact that both numbers are reverse so
    adding number would start from smalleer : tens, hundreds, etc and the carry would work better

    when we take asum e.g. 9 + 5 = 14. 4 is that value that we place and 1 is the left over
    now, let's say we wanted to add the next digits: 2, 5
    so we would get 7 but + the 1 it's 8
    that gives us 29 + 55 = 84 which matches what we just got
    since we got 84, how do we convert that to a node?

    IMPLEMENTATION
    - have a value carry, which is excess of the sum;
    - go thrue each node one at a time
    - sum those values together and update carry (if needed)
    - then we store that sum as a new node
    - move onto next node.
    - sum again, since carry isn't 0, we add that on as well
    - update carry
    - next node

    Edge Cases
    - Lists aren't equal length

    - 
*/