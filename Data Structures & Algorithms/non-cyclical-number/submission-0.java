class Solution {
    public boolean isHappy(int n) {
        Set<Integer> visit = new HashSet<>();

  while (!visit.contains(n)) {
            visit.add(n);
            n = sumOfSquares(n);
            if (n == 1) {
                return true;
            }
        }
        return false;
    }

    private int sumOfSquares(int n) {
        int output = 0;

        while (n > 0) {
            int digit = n % 10;
            digit = digit * digit;
            output += digit;
            n /= 10;
        }
        return output;
    }
}

/*
    Non cyclical number
    - replace each digit the it's square
    - get sum
    - if it stops at 1, that means it's non-cyclical

    ex: 10 => 1**2 + 0**2 =? 1 (sincd 1 doesnt' go anywhere)

    ex: 12 => 1 ** 2 + 2 ** 2 = 5
        5 ** 2 => 25
        2 ** 2 + 5 ** 2 = 27
        2 ** 2 + 7 ** 2 = 51
        : 26, 40, 16, 37. 58

    Non cyclical go back to 1.
    There are an infinite number of possibilets,
    The goal is to be able to come back to a sequence that is has only 1

    WE can dettermine what a non-cyclical number looks like
    but how do we know what a cyclical number is
    assume that cyclical number would overlap a previous sequence in whcih case it's a loop

    Store the sequence of digits in a set as an array
    when we overlap a subset, then we know it's a loop and return cyclical
    If we find that our seqeunce sums up to 1, then we know it's non

    IMPLEMENTATION
    - first we need to parse the digit as an array
    - convert integer to string
    - use two pointer to calculate sum
    - return the sum
    - check to see if conditions are met
    - if not, then recalculaet sum

    EDGE CASES
    - this assumes that it will always repeat to give an overlapping subsequence
    - negtive numbers get a bit tricky
    - 


*/