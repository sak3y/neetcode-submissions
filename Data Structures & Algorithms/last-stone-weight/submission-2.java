class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            maxHeap.add(stone);
        }

        while (maxHeap.size() > 1) {
            int first = maxHeap.poll(); // largest
            int second = maxHeap.poll();

            if (first != second) {
                maxHeap.add(first - second);
            }
        }

        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
}

/*
    Given a list of stones, where the index repersents a stones weight
    Return the final remaining stone after smashign occurs
    - We smash the two heaviest stones
    - if they are equal both get destroyed
    - otherwise, we subtract the bigger stone's weight from the smaller one

    Ex.
    [2,3,6,2,4]
    Two biggest: 6, 4
    remains: 2

    [2,3,2,2]
    Two biggest: 3, 2 (any 2 doesn't matter)
    remains: 1

    [2,1,2]
    Two biggest: 2, 2
    remains: nothing (both are equal)

    res => [1]

    Steps:
    1. find the biggest stone 
    2. find second biggest stone
    3. compare values
    4. perform operation
    5. add back to list
    6. repeat until one stone remains or nothing

    Implementaiton
    - order array so that we can find the two biggest
    - take the two biggest from a stack/list
    - cacluate their complement 
    - add back
    - if complement is 0
    - no need to add back
    - sort again
    - repeat

    Optimisations
    - say we only care about the two biggest at any given time
    - we can use a heap, since after an operation, we can push the value back into the heap and be given the max and second max at any given time
    - the rest, we just do the operations

*/