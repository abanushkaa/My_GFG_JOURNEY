import java.util.*;

class Solution {
    // All 8 possible knight moves
    private static final int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
    private static final int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    
    public ArrayList<ArrayList<Integer>> knightTour(int n) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        
        // initialize board with -1
        int[][] board = new int[n][n];
        for (int[] row : board) Arrays.fill(row, -1);
        
        board[0][0] = 0; // starting point
        
        if (solve(0, 0, 1, board, n)) {
            // convert to result format
            for (int i = 0; i < n; i++) {
                ArrayList<Integer> row = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    row.add(board[i][j]);
                }
                result.add(row);
            }
        } else {
            result.add(new ArrayList<>(Arrays.asList(-1))); // no solution
        }
        
        return result;
    }
    
    private boolean solve(int x, int y, int moveCount, int[][] board, int n) {
        if (moveCount == n * n) return true; // all squares visited
        
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (isSafe(nx, ny, board, n)) {
                board[nx][ny] = moveCount;
                
                if (solve(nx, ny, moveCount + 1, board, n)) return true;
                
                // backtrack
                board[nx][ny] = -1;
            }
        }
        return false;
    }
    
    private boolean isSafe(int x, int y, int[][] board, int n) {
        return x >= 0 && y >= 0 && x < n && y < n && board[x][y] == -1;
    }
}
