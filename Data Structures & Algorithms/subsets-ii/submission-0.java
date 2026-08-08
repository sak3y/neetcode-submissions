class Solution {
    Set<List<Integer>> res;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new HashSet<>();
        Arrays.sort(nums);

        backtrack(nums, new ArrayList<>(), 0);
        return new ArrayList<>(res);
    }
    private void backtrack(int[] nums, List<Integer> cur, int i) {
        if (i >= nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

        cur.add(nums[i]);
        backtrack(nums, cur, i + 1);
        cur.remove(cur.size() - 1);
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
        backtrack(nums, cur, i + 1);
    }
}

/*
    Return all subsets
    - NO dupes
    - a subset: whatever elements makes up the whole set including the set itself and an empty set

    Typically, finding a subset revolves around picking out all sequence of elements
    Ex. [1,2,3]
    a subset is always [1,2,3] and []
    its also: [1], [2], [3], [1,2] [1,3], [2,3]
    (no 2 substs are the same and dupe elments in the subset mean that the list can be any size depedning on the elements)

    Solution
    - To find subset, we can break the problem down into it's subproblem
    - E.g. [1,2,3] becomes the subset of [1,2] which then becomes the subset of [1] which is 1 and []
            and subset of [2] which is 2, []. 
    - Using a set, can determine that there are three subset looking just at the elements themselves
    - combining 2 and 3, we can see that: subsets are []

    Decision tree
    - using an index i
    - we can decide whether to add i or not to our values
    - recurisively do the same for each of the trees we just created
    - that way we get all possible values
    - to hadnle dupes we sort those values then add them to a set
*/