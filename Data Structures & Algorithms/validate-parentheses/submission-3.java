class Solution {

public boolean isValid(String s) {
    if ((s.length() & 1) == 1) return false;
    
    char[] stack = new char[s.length()];
    int top = 0;

    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        switch (c) {
            case '(': stack[top++] = ')'; break;
            case '[': stack[top++] = ']'; break;
            case '{': stack[top++] = '}'; break;
            default:
                if (top == 0 || stack[--top] != c) return false;
        }
    }
    return top == 0;
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