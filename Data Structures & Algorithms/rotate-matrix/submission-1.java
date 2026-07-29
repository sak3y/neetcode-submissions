class Solution {
    public void rotate(int[][] matrix) {
        int l = 0;
        int r = matrix.length - 1;

        while (l < r) {
            int top = l;
            int bottom = r;

            for (int i = 0; i < (r - l); i++) {
                int topLeft = matrix[top][l + i];

                matrix[top][l + i] = matrix[bottom - i][l]; // top left replaced by bottom left

                matrix[bottom - i][l] = matrix[bottom][r - i]; // bottom left replaced by bottom right

                matrix[bottom][r - i] = matrix[top + i][r]; // bottom right replaced by top right

                matrix[top + i][r] = topLeft; // top right replaced by top left
            }
            l++;
            r--;
        }
    }
}

/*
    For a given matrix n x n, rotate every single item by 90 degrees
    Can't use another matrix to store (in place)
    
    For a rotation, elements need to stay consistent.
    - If it's in a corner it stays in the corner
    - if it along the edges, it's n distance from the corner and will stay thay way
    - rotations can be define as a
        translation in the x axis
        a following translation in the y axis
        the distance is travels is always n - 1, where n is the size of one of the sides
        every element is translated except in odd sized arrays, in which case
            the middle element stays in place
    

    We need to do a couple things:
    - knowing how far x and y to move it => based of dimensions
    - be able to translate
    - do it in place (rotation)
    
    BRUTE FORCE
    - create a new array
    - put each rotated element into the new array
        - for each element
        - 
    - copy it back into the original

    SOLUTION
    - we Can treat this as a sequence of subproblems using two pointers
    - For each corner, we know that they will translate to teh next corner over
    - for each value in between corners, they will move to the next side
    - we do this for outer rings
    - We know what a ring is using pointers
    - once a outer ring is clear, move to an inner ring
    - 
*/