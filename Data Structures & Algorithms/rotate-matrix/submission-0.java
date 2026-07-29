class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] temp = new int[n][n];

        // parse matrix
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                temp[c][n - 1 - r] = matrix[r][c];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = temp[i][j];
            }
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
*/