class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int current = num;
                int length = 1;

                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }

                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}
/*
    Intuition:
    - We use hashmap -> O(1) lookup
    - Evaluate a number one index at a time. Look at first index, so val + 1 exist?
    - If yes -> look for val + 2 ...
    - if n and n+1 exist, we can move onto n+1 and n+2 and we keep doing that
    - But n needs to eb the smallest out of the sequence. We don't want to find middle
    - Want longest so we sub out any existing one for whatever is larger
    - Sorting => No, it's O(nlogn) => too slow
    - regular method of trying to find the smallest or largest value is also O(n^2) => no
    -

    Solutions:
    - Initialise variable count
    - We want to find the longest sequence so we evaluate each value
    - we take the largest between current seq and largest seq
    - then we evaluate each value see if n+1 exist iteretively
    -

    Edge Cases:
    - negative numbers -> doesn't change anything
    - array of size 1 means return 1

*/
