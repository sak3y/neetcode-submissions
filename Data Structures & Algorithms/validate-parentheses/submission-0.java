class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if (c == ')' && top != '(') return false;
                if (c == ']' && top != '[') return false;
                if (c == '}' && top != '{') return false;
            }
        }

        return stack.isEmpty();
    }
}
/*
    Essentialy we are given a list of differnt brackets
    Return true if those brack are VALID
    VALID => Open brackets must have either nothing or pairs inside and the close
    E.g. (){}[], {([])}

    How do we keep track of the brackets?
    How do we determine that brackets are in the correct order?
    What is meant be correct oder? and how do we implement this?

    Edge Cases
    - Brackets must be in pairs
    - If there is an open, there must be a close
    - even length list, min length 2 for a valid string
    
    Solution
    - Using a stack pile on each char usign a pointer
    - We push values startin from index 1
    - We hten move the pointer and check. Is it a close brackets and does it match the top of the stack
    - if it does we pop from the stack and move on
    - Otherwise, we push
    - any close that we have must matchthe top of the stack taht way, e1
*/