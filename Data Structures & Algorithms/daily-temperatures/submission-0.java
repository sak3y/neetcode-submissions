class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            int top = temperatures[i];
            
            while (!stack.isEmpty() && top > stack.peek()[0]) {
                int[] pair = stack.pop();
                res[pair[1]] = i - pair[1];
            }
            stack.push(new int[]{top, i});
        }
        return res;
    }
}

/*
    at index 1: we have to wait, 1 day, i.e. when it reaches greater than 30 degrees, so we put 1 at i 1
    at index 2: 38, we have to wait for when the temp is 40, i.e. 4 days, before it's warmer.
    
    Essentiatly, for a given index, how many days do we have to wait, until it gets warmer (assuming there is a day
    where it does get warmer) otherwise, put 0

    Descending temps => all values are 0

    SOLUTION
    - for each index, we use a two pointer soltution.
    - parse each index after, looking for when values are greater, update count as we go
    - update the left pointer, update right pointer to be just after left
    - TC => O(n) since it's a two pointer solution and we have to rely on going the complete array

    Using a stack we can actually make this faster.
    - push 30 into the stack, we then look at the next value, 38, it's bigger so then since condtiion is met,
    - set the legnth of the list - 1 at the first index for res
    - 

    EDGE CASES
    - Last the index will always be 0
    - Second last will always be 1 or 0
    - and so on
    - array of length 1 will always return 0 
*/