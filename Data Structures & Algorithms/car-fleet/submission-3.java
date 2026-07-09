class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] pair = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        Arrays.sort(pair, (a, b) -> Integer.compare(b[0], a[0]));
        Stack<Double> stack = new Stack<>();
        for (int[] p : pair) {
            stack.push((double) (target - p[0]) / p[1]);
            if (stack.size() >= 2 &&
                stack.peek() <= stack.get(stack.size() - 2))
            {
                stack.pop();
            }
        }
        return stack.size();
    }
}

/*
    Cars have a speed and distance and need to get to the target
    They can't overtake each other (only match speed)

    GOAL => Find the number of car fleets
    Cars can either be a fleet on their or own, or if they catch up to one of the cars (even at the end). Then they are considered part
    of a fleet.

    [6, 3, 1, 8]
    [8, 5, 2, 9]
    [10, 7, 3, 10] => remove 10's (Keep track of this process)
    [9, 4]
    [11, 5] => remove over 10
    [5] => [6]... [10] => remove 10

    That was 3 times we remove

    SOLUTION
    Brute force
    To know where any given car is, we take it's postion and speed. Compare against the target, increment the speed until it reaches 
    the target, keeping track of the new postion. Ex. P = 4, S = 2. i1 => 6, i2 => 8, i3 => 10 (TARGET).

    To know which cars are a part of the fleet. On each itteration, we see how many have passed the target, given the new postions of the list.
    Essentialy, it doesnt matter how many reach the target at teh same time, we treat it as 1.

    We do need to keep track of which elements have passed so taht we don't double count them on itteration

    IMPLEMENTATION
    We update the positions using current positons and speed
    Make checks to see if the values are above the target using for loop
    Remove all elements from the list that meet that condition
    Keep track of removals
    Do that until the list is empty

    TC => O(n^2) because each time we update the values, we need to see check

    STACK

*/