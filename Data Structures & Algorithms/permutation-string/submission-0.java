class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

         int need = map.size();
        for (int i = 0; i < s2.length(); i++) {
            Map<Character, Integer> perm = new HashMap<>();
            int cur = 0;

            for (int j = i; j < s2.length(); j++) {
                char c = s2.charAt(j);

                perm.put(c, perm.getOrDefault(c, 0) + 1);

                if (map.getOrDefault(c, 0) < perm.get(c)) {
                    break;
                }

                if (map.getOrDefault(c, 0) == perm.get(c)) {
                    cur++;
                }

                if (cur == need) {
                    return true;
                }
            }
        }
        return false;
    }
}

/*
    Solution
    - Comparing substring with permutations
    - the goal is to compare them against the hash map
    since hashmap comparison order doesnt matter
    - using sliding window to then create a new hashmap and
    then compariosn becomes easy so we adjust that map by adding and removing the last and new
   values
    -

*/