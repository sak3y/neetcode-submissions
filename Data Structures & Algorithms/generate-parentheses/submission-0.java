class Solution {
    List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(n, 0, 0, sb);
        return res;
    }   

    private void backtrack (int n, int open, int close, StringBuilder cur) {
        // base case 
        if (open == n && close == n) {
            res.add(cur.toString());
            return;
        }
        // Add open b
        if (open < n) {
            cur.append("(");
            backtrack(n, open + 1, close, cur);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(")");
            backtrack(n, open, close + 1, cur);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}

/*
    We are givne a number n
    - Return all pair of parentheses (n) that we can have in a valid order
    - Order doens't matter
    - there must be n pair of parentheses
    - No dupes

    At n = 1:
        "()"
    n = 2:
        "(())", "()()"
    n = 3:
        can we take the pairs from 2, and construct new pairs?
        well given (()), if we insert a pair at every index: ()(()), (()()), ((())), (()())*, (())()
        and ()(): ()()(), (())(), ()()()*, ()(()), ()()()*.

    So this BRUTE FORCE:
    - we work recursively
    - take all pairs at 1, insert pairs for each index. 
    - base case: when our cur is empty.
    - Work up by adding values in at each index
        starting at an empty string means we only insert in one position
    - at n = 1
        we have (), which is 2 values. We can insert at the beginning, middle and end:
    - store results
        handles dupes as we go along
            Using a set we can add values then convert to a list

    
    ALT
    - we knwo that the number of ( must always match ) right
    - they also must be = to n at the n.
    - We also know that we cant open brackets if the closed number is greater
    - We must always start with open
    - using tht logic
    - we can track the number of 
        - open b
        - close b
    - using condition:
        If open != close -> invalid
        If open == close -> valid
        Open at any stage must always be >= close
        using a decision tree, we can add values in recursively.
        to cover all possible options
    
    
*/