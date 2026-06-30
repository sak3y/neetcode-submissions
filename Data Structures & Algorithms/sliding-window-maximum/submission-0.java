class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();

        int r = k;

        while (r <= nums.length) {
            int max = nums[r - k];

            for (int l = r - k; l < r; l++) {
                if (nums[l] > max) {
                    max = nums[l];
                }
            }

            res.add(max);
            r++;
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}

/*
    IDEA
    - we have an array
    - an integer k
    - Goal is to return a list of biggest elements at each window
    - slidiwing window tech with two pointer sol shifting windows by 1 each time and whilst
   caclulating max
    - brute force solutoin
    - we have our window from 0 - 3. Than loop over that and return the max val which gets stored in
   the list.
    - Do that again with teh new window utni the r pointer can't go any further

    EDGE CASES
    - windows can't be bigger than the array
    -

*/