class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }

        int slow2 = 0;
        while (true) {
            slow = nums[slow];
            slow2 = nums[slow2];        

            if (slow == slow2) {
                return slow;
            }  
        }
    }
}

/*
    Given an array of integer nums
    Find the dupe
    array size = n + 1
    Integers are between [1, n] (inclusive)

    Idea
    - because we are looking for dupes, we need to store values
    - Most obviously a set, since it's made to store unique values
    - SC: O(n), TC: O(n)
    - if we want an O(1) solutions, the using a two pointer solution would make sense here however that would increase tc
    to O(n**2)


*/