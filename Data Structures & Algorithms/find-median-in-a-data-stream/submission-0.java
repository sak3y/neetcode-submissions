class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);

        if (maxHeap.size() - minHeap.size() > 1 || 
        !minHeap.isEmpty() && 
        maxHeap.peek() > minHeap.peek()) 
        {
            minHeap.offer(maxHeap.poll());
        }
        if (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if (maxHeap.size() == minHeap.size()) {
            return (double) (minHeap.peek() + maxHeap.peek()) / 2;
        } else if (maxHeap.size() > minHeap.size()) {
            return (double) maxHeap.peek();
        } else {
            return (double) minHeap.peek();
        }
    }
}


/*
    Find the median for a dynamic list

    MedianFinder:
        - initialise the clss
        - have a list (keep track of numbers added so far) 

    AddNum:
        - update list by appending number
    
    FindMedian
        - takes the middle value (if odd lenthed list)
        - otherwise
            - takes two middles values and find the mean

    
    - Need to keep array sorted
    - Need to only know the two middle values at all times or middle value depending on the length
    - Global list that can be accessed

    BRUTE FORCE
    - Create a list
    - add numbers to that list with addNum
    - findMedian =>
        Array must be first sorted, so whatever numbers where added to the list
        then we need to determine whether it's an odd lengthed list
        Calculate the median and return it as a double

    TC: O(nlogn) => sorting is the taxing operation

    OPTIMISED SOLUTION
    - we know that at any given time, we only need to know the two middel values
    - And those values need to be sorted in the full thing
    - but we don't want to sort the entire thing each time
    - therefore a heap would make sense here
    - but how do we keep track of the middle values?
        since a heap only looks at biggest / smallest values
        and the values we care about are in the middle
        if there was a way to split the sorted array in half and take the max heap of the smallest side 
        and the minheap of the bigger side
        and whenever their length was equal

    Ex. say we have the list [4, 3, 1, 7 ,2] => [1, 2, 3, 4 ,7] with median 3


*/