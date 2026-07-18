class Solution {
    public int characterReplacement(String s, int k) {
        Set<Character> charSet = new HashSet<>();
        for (char c : s.toCharArray()) {
            charSet.add(c);
        }

        int res = 0;
        for (char c : charSet) {
            int count = 0, l = 0;
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
    GOAL: Find the n number of longest subarray of consecutive characters given k number of changes

    INUITION
    - We can use a two pointer solutions that extends the length of the string
    - We greedily makes changes so say we a poitner on 'x', anyything that isn't x, we sub,
    - Then take the lenght of that windows once k hits 0
    -

    ISSUES:
    - We need to be able to make inteligent choices about what values to change since k is limited
    - Track the longest for each char
    -


    'A A A B A A B B'

    FINDING THE CORRECT POSITION TO USE K
    - at first we take the first instance that there is a non 'A' value.
    - have pointers l = 0, and r = 3.
    - since r at 3 is B.
    - use k, so k = 0
    - we are then able to extend r
    - r reaches 5.
    - no more k's so we comute r - l which is 5.

    IMPORTANT => we made the greedy choice of choosing the first 'B', but that may not be the
   longest substring ADDITIONAL STEPS

    - we got to k = 0 and ended
    - but what we can do now since we are looking for the longest substring and since we need to be
   exhaustive
    - set l to previous value of b + 1, reset k
    - Do that for each character in the

    IMPLEMENTATION
    - Hashmap to store chars
    - Sliding windows start wth the first char
    - Greedy use k, then return window length
    - Exhaustive with this approach

    TC:
    HashMap => O(n) to intialise, lookup: O(1), storing: O(1)
    Sliding window: O(n) for each char in hashmap => O(n*m)

    FASTER SOLUTION?
    - for eahc vlaue we look at the frequency of each char.
    - Naturallly, the chars with the highest frequencies we would be able to get the most out of.
    - So there isn't a need to look at each char.
    - Take: "C A A A B A A B B C"
    A = 5
    B = 3
    C = 2

*/