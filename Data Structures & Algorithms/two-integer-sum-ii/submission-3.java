class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;

        while (l < r) {
            int sum = numbers[l] + numbers[r];

            if (sum == target)
                return new int[] {l + 1, r + 1};
            else if (sum > target)
                r--;
            else
                l++;
        }
        return new int[] {};
    }
}

/*
    Intuition:
    - two pointer, binary search? -> since we're looking for two numbere, this wouldn't make sense.
    - we know that index1 < index2 so find index one means the solutions must exists inthe lower
   half and vice versa.
    - How do we find the index2? well, it has to be > target - 1 -> essentailty we can look for
   taget and reduce the search by best case a half -> narrower serach means shorter time complexity
    - obvious solution here would be to use a hashset and lookup is O(1) -> but that would be using
   O(n) space so not viable
    - if we use

*/