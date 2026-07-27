class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];

            // check if target - k is in map, if so return their indexes
            if (map.containsKey(val)) {
                return new int[]{map.get(val), i};
            }

            map.put(nums[i], i); // store
        }
        return new int[]{};
    }
}

/*
    Looking fro two numbers such that both sum up to target
    Pairs always exists => q states that

    BRUTE FORCE
    - using two pointer, we can find a solution, such that i1 and i2 eventually
    add up to equal target
    - a + b = t
    - TC: O(n**2)

    Optimised Solution
    - hashmap
    - quick lookup
    - we look for values target - i, where i is the current index
    - then we search for the value that equals to
    - in a hashmap, lookup is o(1)
*/