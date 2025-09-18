// User function Template for Java
class Solution {
    // Function to search a given integer in a matrix.
    public boolean searchMatrix(int[][] mat, int x) {
        int rows = mat.length;
        int cols = mat[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == x) {
                    return true;
                }
            }
        }
        
        return false;
    }
}

