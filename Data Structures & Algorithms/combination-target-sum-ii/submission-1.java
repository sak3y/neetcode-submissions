class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> cur = new ArrayList<>();

        backtrack(candidates, target, cur, 0);
        return res;
    }
    private void backtrack (int[] candidates, int target, List<Integer> cur, int i) {
        if (target == 0) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (target < 0 || i >= candidates.length) {
            return;
        }
        
        cur.add(candidates[i]);
        backtrack(candidates, target - candidates[i], cur, i + 1);
        cur.remove(cur.size() - 1);

        // Handles dupes since array is sorted
        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i++;
        }

        backtrack(candidates, target, cur, i + 1);
    }
}

/*
    Given candidates, an array that may contain dupes and target
    GOAL -> Return a list of UNIQUE combinations that sum up to target
    - the items can be returned in any order
    - each item can only be chosen once, which means once we select it, it's no longer an option
    - Say we have [1,2,3,4,5], t = 7
    
    we pick 1, options remaining are: 2, 3, 4, 5
    pick 2, remaining are 3, 4, 5
    pick 3, remainig are 

    BACKTRACK
    in a decision, tree we can choose to add the value at i or not
    i always updates since no dupes allowed
*/