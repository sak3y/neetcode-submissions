class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList();
        backtrack(nums, target, 0, cur);
        return res;
    }
    private void backtrack(int[] nums, int target, int i, List<Integer> cur) {
        if (target < 0 || i >= nums.length) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList(cur));
            return;
        }
        cur.add(nums[i]);
        backtrack(nums, target - nums[i], i, cur);
        cur.remove(cur.size() - 1);
        backtrack(nums, target, i + 1, cur);
    }
}

/*
    We are looking for all possibile comninations tat sum up to target (dupes included)
    - want the sublists to be original tho
    

    BRUTE FORCE
    - A simple way is to try out every possible combination.
    - say target is 9
    - starting at 2, (given ex1)
    - there are 4 possible additions we can make: [2, 5, 6, 9]
    - however only 3 of them are valid, since 9 will put us over the target
    - that then gives us three distinct tree
    - we can then further perfrom calculations, adding to our res if the comination equals targets and throwing them away if
    they are greater
    - the only issue is dupes. And this is an issue because the dupes can be in a differnt order but hold the same values
    - that way sorting each one and then using a set to seperate

    Optimised
    - instead of capturing dupe combinations in our res
    - we can use backtracking recursively to leave out dupes
    - say we start with 2.
    - on the left we choose to use 2 again
    - on the right, we don't use any twos
    - that way we have one path that only reuses 2s and then at different points, we cut off from using 2s
*/