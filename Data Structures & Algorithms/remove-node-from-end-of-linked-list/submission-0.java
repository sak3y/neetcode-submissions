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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> arr = new ArrayList<>();

        // Construct the list
        while (head != null) {
            arr.add(head);
            head = head.next;
        }
        
        // Remove the nth end node
        int pos = arr.size() - n;
        arr.remove(pos);

        if (arr.isEmpty()) return null;

        // Construct updated node
        ListNode res = new ListNode();
        for (int i = 0; i < arr.size() - 1; i++) {
            res = arr.get(i).next = arr.get(i + 1);
        }
        arr.get(arr.size() - 1).next = null;

        return arr.get(0);
    }
}

/*
    GOAL: REMOVE NTH NODE FROM END OF LIST
    
    INTUITION
    - Start at the end of a list
    - Count n + 1 values backwards
    - Update that node's pointer to point the 2 values in front
    - return the list
    
    To calculate the nth end value from the front => take len of list - that value
               v 
    ex: [1,2,4,5,6,7], n = 3. Len = 7. So the node we want to be at is node = 3

    get the length
    go to the len - 1 - n node
    update it's poiter to go
    which doesn't work if that node is the start or it's doesnt' have three values


    Edge cases
    so if n is at start point, move head to next and point first ot null
    if n is at the end, point to null

    ALTERNATIVE SOLUTION
    - WE CAN STORE THE NODES.
    - REMOVE THAT NODE FROM THE LIST BY USING LEN
    - constucuct a new node list

    TC: O(n) + O(n)
*/