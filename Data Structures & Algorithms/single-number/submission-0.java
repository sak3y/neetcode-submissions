class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;

        for (int num: nums) {
            res ^= num;
        }
        return res;
    }
}
/*
    GOAL => Find a number x that only appears once

    BRUTE FORCE SOLUTION
    - For a given number i, we see if any other instances are present. 
    - Say we look at index 1. Then we implemenet a two pointer solutions with a nested loop
    - if we see that another values exists = to the value we are looking at, i.e, index 1 then break
    - otherwise we return that as our values

    TC: O(n^2).

    OPTIMISED
    - For each instance of value, we add it to a set.
    - before adding, we check the set to see if that value exists which is O(1) lookup
    - parse the array until we find the value that doesn't exist which is O(n).

    TC: O(n) + O(1)
    SC: O(n)

    OTHER OPTIMISED
    - We sort the algorithms => 

    Bit Manipluation
    - Because we know that there exists two states of every answer except a single one
    - Using XOR, which looks at differeces exlusively, we can cancel out any duplacates since their bit represanation would 
    default to 0. Eg. {3, 3} => {011, 011} 1 ^ 1 = 0, 1 ^ 1 = 0, 0 ^ 0 = 0. 
    - Since it's not orderd, we can't just compare dupliactes since we don't know where they are.
    - But XOR still works. Take {4, 3} => {1000, 0011}: => 1011 = 7. Eventually all duplcates will fall back in place
    {4, 3, 4, 3, 1} => {1000, 0011, 1000, 0011, 0001} => {1011, 1000} => {0011, 1000} => {1011, 0011} => {1000, 0001} => {1001}


    EDGE CASES
    - If there are no unqiue values
    - array with len 1 => means only one possible solution
    - there could be multiple solutions => q says that only one unique solutiosn exists
*/