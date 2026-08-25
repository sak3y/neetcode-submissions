class Solution {
    public int[] plusOne(int[] digits) {
        int size = digits.length;

        for (int i = size - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            }
            else {
                digits[i] = 0;
            }
        }
        if (digits[0] == 0) {
            int[] res = new int[size + 1];
            res[0] = 1;
            return res;
        }
        return digits;
    }
}
/*
    digits represents the digits of a large number
    We want to add 1 to that numberr
    GOAL: return the result after adding one

    So for any number where the last digitt is less
    than 9, we can safely just increase that number
    but for values that arer at 9, then we have to turn that number to 0 and look att the next number and add it there.
    If all values are above 9, then we need to  

*/