class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        backtrack(nums, new ArrayList(), new boolean[nums.length]);

        return res;
    }
    private void backtrack(int[] nums, List<Integer> cur, boolean[] picked){
        if (cur.size() == nums.length) {
            res.add(new ArrayList<>(cur));
            return;
        }

for (int i = 0; i < nums.length; i++) {
        if (picked[i] == false) {
            picked[i] = true;
            cur.add(nums[i]);
            backtrack(nums, cur, picked);
            cur.remove(cur.size() - 1);
            picked[i] = false;
        }
    }
    }
}

/*
    All elements in nums are unique
    Goal -> Return all perumations

    Permutation: different ways we can represent a list of items
    - All items are the same but their order is different
    - Permutations of a set include the set

    Ex. [1,2,3]
    we keep 1 and change the order of everything else
    -> [1,3,2]
    -> keep 2 change: [3,2,1]
    -> keep 3, change: [2,1,3]

    taking this to the decision tree

    Intuitivelt, wehen building the list, we can
    - start with any value
    - not reuse an option once we have chose it
    - do that exhaustively
*/