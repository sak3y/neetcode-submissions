class Solution {
    public int characterReplacement(String s, int k) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            set.add(c);
        }
        int res = 0;
        
        for (char c : set) {
            int count = 0;

            int l = 0;
            for (int r = 0; r < s.length(); r++) {
                if (s.charAt(r) == c) {
                    count++;
                }

                while ((r - l + 1) - count > k) {
                    if (s.charAt(l) == c) {
                        count--;
                    }
                    l++;
                }

                res = Math.max(res, r - l + 1);
            }
        }
        return res;
    }
}

/*
    Problem
    - Need to first replace a K number of letters
    - Those letters need to then form a sequence of single characters
    - Find the longest possiible sequence by using that principle
        Sub Problems
        - Need to figure out which K characters to replace => what's thet best
        like do we pick 'a' or 'b' in the exm => start w l
        - figure out how we will deal with replaced chars once they move out of the window


    Solution
    - sliding window
    - start with pointer r that moves up and a count that keeps trakc of current longest
    - if new character and k is non-zero, then we use k
    - if non new character and k is non-zero, then update curr count
    - if non new charr and k is zero update, contniue
    - if new char and k is 0, then we need to update l
    - then we run math.max to get the biggest value

    Edge Cases
    - s length > 0 so we fine
    "BAACAABA" k=2 => O(n)
*/