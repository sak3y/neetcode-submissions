class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparing(a -> a[0]));

        for (int i = 0; i < points.length; i++) {
            int x = points[i][0];
            int y = points[i][1];

            // Euclidean distance
            int distance = ((x * x) + (y * y));

            minHeap.offer(new int[]{distance, x, y});
        }

        int[][] res = new int[k][2];

        for (int i = 0; i < k; i++) {
            int[] point = minHeap.poll();

            res[i] = new int[]{point[1], point[2]};
        }
        return res;
    }
}

/*
    Given a list of poitns
    Find the point closest to the origin up to k times
    Distance => Euclidean distance => sqrt((x**2) + (y**2)) -> since distance between two points where one is the origin so 
    
    BRUTE FORCE
    - We Calculate the eucidena distance for each pont
    - take the x and y and get the distance and store it
    - do taht for all values in teh list
    - and then sort them.
    - return the first k number of values
    - sicne we need the points, we need to create a map of thsoe values
    - so we first create a map of 

    OPTIMISED
    - Since we only care about the first k values with the smallest euclidena distance to the origin
    - We only care about the points with the smallest distance
    - adn we don't know whcih of those poitns are the smallest
    - we can go thru the list
    - add them to a min heap
    - then that way we get smallest values inside there
    - when we pop, those values get return from smallest to largest
    
    Can put values into a heap, how do we map those values back to the 


*/