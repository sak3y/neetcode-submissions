class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();

        int l = 0;
        int r = 0;

        while (l < nums1.length && r < nums2.length) {
            if (nums1[l] <= nums2[r]) {
                res.add(nums1[l]);
                l++;
            }
            else {
                res.add(nums2[r]);
                r++;
            }
        }

        while (l < nums1.length) res.add(nums1[l++]);
        while (r < nums2.length) res.add(nums2[r++]);

        int n = res.size();
        if (n % 2 == 1) return res.get(n / 2);
        return (res.get(n / 2 - 1) + res.get(n / 2)) / 2.0;
    }
}

/*
    Given two arrays:
    GOAL: to find the median if we were to combined those arrays

    Median is the middle value, if there are two values, we just get the mean
    Both are sorted.

    First approach is two combine the two arrays and then find the median -> leads to an unsorted array which we would then have to sort at O(nlogn)? .

    [1,4,7], [2,3,5]

    Approach:
    - we can sort the arrays in less than o n log n time since they are already sorted.
    - Using a two pointer approahc, initialise a new array were we add values in ascending order
    - Finding the mediann -> middle values / mean of the two values if the length is eve
    - TC: O(n+m)
*/