class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return Arrays.asList(new ArrayList<>());
        }
        // We create permutations and work up
        List<List<Integer>> cur = permute(Arrays.copyOfRange(nums, 1, nums.length));

        List<List<Integer>> res = new ArrayList<>();
        
        // Inserting value into each positiion
        for (List<Integer> c : cur) {
            for (int i = 0; i <= c.size(); i++) {
                List<Integer> copy = new ArrayList<>(c);
                copy.add(i, nums[0]);
                res.add(copy);
            }
        }
        return res;
    }
}
/*
    Permutation: a way of aranging integers so tbe different orders that they can representions

    There are always n! number fo permutation where n is the len

    To find a permutation
    We select an element and move it around
    Ex. [1,2,3]

    We can actually just take a value for example 1 and just place it in the sublist [2,3. Thhere are three valid spotts giving us solutions.
    Tthe otther perumatation is [3,2]

    Firstt we get the sublists for each, which at base case is [], working up we get values and those permutations are themselve
    when getting to two digits, permutations sttart occuring where we get an list of 2 values. this is where we can decide to insert values.

*/