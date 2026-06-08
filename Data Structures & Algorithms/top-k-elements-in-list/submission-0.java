class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        // this gets the values and their frequencies
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort((a, b) -> b.getValue() - a.getValue());

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = entries.get(i).getKey();
        }

        return res;
    }
}

/*
    Intutition:
    - We can map frequencies and their values using a hashmap.
    - We then sort the values based on their frequency
    - Then values that are the most frequent up until k frequency get returned
    - Time complexity: O(nlogn)

    Solution:
    - initiate a hashmap
    - then fill in that map by using a for loop and then putting those inside checking conditions as
   we go along.
    - Sort that map by turinging into a list then running Arrays.sort
    - return the most common ones up utnil n

    Edge Cases:
    - if array len is less than 2, return one value and that would be the only value in there
*/
