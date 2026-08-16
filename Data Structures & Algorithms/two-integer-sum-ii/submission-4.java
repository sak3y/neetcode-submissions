class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;

        while (l <= r) {
            int sum = numbers[l] + numbers[r];

            if (sum == target) return new int[]{l + 1, r + 1};
            else if (sum > target) {
                r--;
            }
            else {
                l++;
            }
        }
        return new int[2];
    }
}

/*
    Sorted array
    It's indxed
    One solution always exists
    We can't reuust the same index
    So idx 1 < idx 2: [idx1, idx2]
    GOAL: Return the two indexes, whose values sum to target
    O(1) additional space

    Sorted => binary, doesn't take an additional space + already sorted

    Two pointer either ends
    take their sum.
    if sum > target, then we need smaller vals, so we right p left
    else move left p right
    do that until l == r, in whcih case we would have found our solution and we don't want r == l 

    TC: O(n), but since it's sorted, we can somehow get that down to O(log n)

*/