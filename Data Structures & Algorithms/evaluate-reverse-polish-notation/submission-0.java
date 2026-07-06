class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+")) {
                int top = stack.pop();
                int bottom = stack.pop();
                stack.push(bottom + top);
            } else if (token.equals("-")) {
                int top = stack.pop();
                int bottom = stack.pop();
                stack.push(bottom - top);
            } else if (token.equals("*")) {
                int top = stack.pop();
                int bottom = stack.pop();
                stack.push(bottom * top);
            } else if (token.equals("/")) {
                int top = stack.pop();
                int bottom = stack.pop();
                stack.push(bottom / top);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.peek();
    }
}

/*
    Reverse Polish notation => operands come after the numberse
    pattern => a b + c - ..., firs two are numbers then its numbers, operand (repeated)
    BODMAS => assume that it's rolling, we evaluate numbers left to right so in the examples,
    and values can either be a numebr of operator => that's our input

    EDGE CASE
    - Handling division by 0 => assume that we can't do that and ignore it

    SOLUTION
    Using a stack, we can put numbers on top so first would be {1, 2}
    when a non integer, i.e. an operator apppears, we evaluate the two numbers in the stack, for
   examples {1, 2} and {+} would become 3. We would pop the top values, use the operator and then
   pop the next value. then push that res to the stack, now we have {3}, push 3 => {3, 3} and then
   move to '*' => then taht becomes 3 * 3 = 9, push that onto stack. This assumes that it ends with
   an operator and ignores bodmas, whhich fine. This looks like an O(n)
*/