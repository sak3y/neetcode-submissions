class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length())
            return "";

        // populating hashamp with substring
        Map<Character, Integer> t1 = new HashMap<>();
        for (char c : t.toCharArray()) {
            t1.put(c, t1.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> s1 = new HashMap<>();
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;
        int have = 0;
        int need = t1.size();
        int l = 0;

        // populating t
        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            s1.put(c, s1.getOrDefault(c, 0) + 1);

            //
            if (s1.containsKey(c) && s1.get(c).equals(t1.get(c))) {
                have++;
            }

            // restricting window size
            while (have == need) {
                if ((r - l + 1) < resLen) {
                    resLen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }

                char leftChar = s.charAt(l);
                s1.put(leftChar, s1.get(leftChar) - 1);
                if (t1.containsKey(leftChar) && s1.get(leftChar) < t1.get(leftChar)) {
                    have--;
                }
                l++;
            }
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}

/*
    Idea
    - return a substring that is the shortest length but meets the below
    - tt has to include every char in t (including dupes)
    - it doesnt have to be in order - as long as it has those values
    - to find a substring we have to look thru all possible substring combinations that include all
   chars
    - and it has to be the shortest one
    - So how do we determine a path for evaluating substring inteligently
    -


    Edge Cases
    - the length of t must be less than s otherwise it won't work

    "OUZYXAWZ", t = "XYZ"


    Solution
    - we are comparing substrings not for total equality
    - but to see if the requirement i.e. the vluaes of t are met
    - we keep a track of both arrays and use sliding window
    - as the array map becomes progressively bigger make checks to see
    - if the requirements are met -> this way we know exactly when
    - we get the shortest string
    - how do we compare arrays?
    - using hashmaps, or a var like count and seeing if it matches
    to the length of our string


    - sliding window
    - we have a map of the current string s => o(n) and t => O(n)
    - we have l and r pointers at each end of s
    - we then shorten l or r, doesn't matter which as long as t is
    present => this will be a hashmap comparison
    - maybe as we create the map, see if

*/