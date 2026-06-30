class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        for (int i = 0; i < nums.length; i++) {
            heap.offer(new int[] {nums[i], i});

            while (heap.peek()[1] <= i - k) {
                heap.poll();
            }

            if (i >= k - 1) {
                res[i - k + 1] = heap.peek()[0];
            }
        }

        return res;
    }
}

/*
    IDEA
    - For a max heap. The way it works is that they are a tree like strucutre and biggest numbers
   get placed at the top. in descending order
    - and for a window, there are two cases after we add the window in.
    - Keep track of number at the rist window.
    - Keep track of max => this is fine since the heap will give us max

    2 => 1
     => 1
    -

*/