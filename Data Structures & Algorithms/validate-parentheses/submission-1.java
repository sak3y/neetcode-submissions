class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                continue;
            }

         
        if (stack.isEmpty()) return false;
        char top = stack.pop();
        if (c == ')' && top != '(') return false;
        if (c == '}' && top != '{') return false;
        if (c == ']' && top != '[') return false;
        }

        return stack.isEmpty();
    }
}

/*
    Find valid string
    valid if open is matched by close
    Order needs to be correct

    The idea is 
    - We push values that are open
    - when we push a value, upon seeing a close we should be able to pop
    - we know that if we get a stray value 
    - we can greedily pop from teh algo as well
    - return list is empty
*/