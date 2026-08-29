class Solution {
    public int numDecodings(String s) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(s.length() - 1, 1);
        return dfs(0, s,dp);
    }
    private int dfs(int i, String s, Map<Integer, Integer> dp) {
        if (i >= s.length()) return 1;
        if (s.charAt(i) == '0') return 0;
        if (dp.containsKey(i)) return dp.get(i);
        
        int res = dfs(i + 1, s, dp);
        if (i < s.length() - 1) {
            if (s.charAt(i) == '1' || s.charAt(i) == '2' &&
            s.charAt(i + 1) < '7') {
                res += dfs(i + 2, s, dp);
            }
        }
        dp.put(i, res);
        return res;
    }
}
/*
    String -> to be decoded
    Number map to chars from 1 -> 26
    GOAL: get all possible ways we can decode the string

    Given: "112031"
    - we know a char can be max 2 digits, so eitherr 1 or 2 long
    - a char can't start with 0
    - when we evaluate a substring, looking at the first val
    - so either we can take the first val assuming it's non 0
    - or we can take the first and second val and make a number from that
    - this works recursively since we would branhc out depending on the decision we make -> hence a decision tree
    - edge / base cases. 
        We know that a value must be under 27
        that values like 10 and 20 are always true, meaning that if we see a 0, it's has to either be preceeded by a 1 or 2
        that our string can't start with 0

    Implementation
    - We run a dfs on our decision tree
    - at each decision we either take one or two digits
    - we run that recurirsively
    - our base case it obviously when we are out of bounds, so a pointer that stand on our current digit
    - and then we run dfs on the double val
    - make sure it's not out of bounds
    - also make sure that we aren't creating a digit that starts with 0
    - if we start our val on a 2, then our second value must be below 7     - hold shit, when we actually draw out the decision tree, it ends up being a binary tree and our results is basically just dfs and seeing if we reach the end of the string.
    - in that case, there are only 2 results
    - things tthat break our tree are listed above, but include invalid numbers, starting a number at 0

    optimistation
    = we have the recursive solution but a lot of our compuattions arer rerpeated in teh decision tree
    - instea we can sttore values to save time
*/