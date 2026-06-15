class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int l = i + 1;
            int r = nums.length - 1;
            int target = -nums[i];

            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum == target) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    r--;

                    while (l < r && nums[l] == nums[l - 1]) l++;
                    while (l < r && nums[r] == nums[r + 1]) r--;
                } else if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return res;
    }
}

/*
    Intuition:
    - i, j, k cannot be equal
    - results are 0 - many
    - find all possible combinations that net 0
    - no duplicates allowed
    - since it can be in any order and the results are the values and not the index
    we can order and mutate the array in any way we want -> order from smallest -> largest
    - Since we need to get every solution (no duplicates) -> can we parse in one go and find all the
   combinations?

    Solutions:
    - three pointer solution -> O(n^3) -> if brute forced
    - if i + j + k = 0
    then: i + j = -k
    that means we only need to find i + j
    if we take the first value e.g. -1 and set that to k, then k = 1
    so we then run a two pointer to look for that k value
    then we use the two pointer solution O(n) solutions which then closes in on the middle value
    ignoring indexes of het same value.
*/