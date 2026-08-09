class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, new ArrayList<>(), 0);
        return res;
    }

    private void backtrack (int nums[], List<Integer> cur, int i) {
        if (nums.length <= i) {
            res.add(new ArrayList<>(cur));
            return;
        }

        cur.add(nums[i]);
        backtrack(nums, cur, i + 1);
        cur.remove(cur.size() - 1);
        while (i  + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        
        backtrack(nums, cur, i + 1);
    }
}

/*
    Given an array of nums
    - return all subsets that arne't duplicates
    Subset: any part of the set that includes the exact same element

    SOlving for a subset
    Ex. [1,2,3], [] and [1,2,3]
    [1], [2], [3]
    [1 2], [1,3], [2,]

    so we can use a decsion tree to decide whether to include an elemenet or not
    because we aren't allowed dupes we have to deal with that as well
    
    Implemnetaion
    - Using an index i, create two instances where one tree includes i and one doesn't
    - incrememnt i, then run recusrively on all decision trees
    - handle dupes before each recursion
    - 
*/