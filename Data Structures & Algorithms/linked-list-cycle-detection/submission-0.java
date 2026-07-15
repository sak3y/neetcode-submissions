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
        Set<ListNode> set = new HashSet<>();

        while (head != null) {
            if (!set.add(head)) return true;

            set.add(head);
            head = head.next;
        }

        return false;
    }
}

/*
    INTUITION
    - A cycle => when the next of a node point back to one of the nodes that's already been visited.
    In the examples, when we get to the last node, 4, we see that it points to 2 which means we are revisiting

    A hiddrn var, index exisits that causes a cycle. In any case a cycle occurs if the value is not -1

    Determining a cycle has occured
    - Since values are not unique, and indexes in linked list don't occur, we need to find another way of seeing that the same values exist.
    - We could look at the sequence of nodes visited, taking their values and if they match up say n number of times then we can return true
        but that isn't reliable due to chance
    - Another things we can do is a two pronged approach.
    - We know that a cycle will endlesssly repeat over the same nodes.
    - SO if we somehow have two lists where one is faster than the other.
    - If there is a cycle, eventually the faster one will spin round to match  the slower one.
    - If there isn't the faster one will never match since it's ahead and that will stay away.
    - Looking at it like a race, if the race track is like a circuit, eventually one will lap the other.

    How does this work and how do we determine that that it isnt' a circuit -> in which case we can never know 

    - Because a non cycle wwould come to an end we can check null values to seeif it exists

    SOLUTION
    - We have one list: slow, which goes at a pace of 1 node at a time
    - Another list: fast, which goes twice the speeds, skipping every adjacent node
    - As long as none of them reach a null values,
    - If at some point, they do overlap we can slow down to see if they repeat. => how do we know this sint' due to chacne
*/