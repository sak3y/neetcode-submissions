class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    for (int s : stones) pq.offer(s);

    while (pq.size() > 1) {
        int y = pq.poll();   // biggest
        int x = pq.poll();   // second biggest

        if (y != x) {
            pq.offer(y - x);
        }
    }

    return pq.isEmpty() ? 0 : pq.poll();
    }
}
/*
    Find the weight of the final stone after smashing
    x == y: both destroyed
    x < y: x destroyed, y is the new weight y - x

    BRTUE FORCE
    - compare two stones, at any position but we'll do 0 and 1 index
    - we check conditions, if they are equal of not than destroy appropriatetly
    - return the new stone 
    - add that to the list
    - repeat

    OPTIMISED
    - soring:
        - we could sort the algorithm so that duplicate values are next to each other -> destroying both stones is better for efficienty
    - Heap:
        - Order values in a tree with min/max at the top

*/