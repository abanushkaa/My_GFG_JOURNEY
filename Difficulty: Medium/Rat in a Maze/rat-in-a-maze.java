import java.util.*;

class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        ArrayList<String> res = new ArrayList<>();
        int n = maze.length;
        
        // If starting or ending cell is blocked, no path exists
        if (maze[0][0] == 0 || maze[n-1][n-1] == 0) 
            return res;
        
        boolean[][] visited = new boolean[n][n];
        StringBuilder path = new StringBuilder();
        
        // Start from (0, 0)
        dfs(maze, n, 0, 0, visited, path, res);
        
        // Sort results lexicographically
        Collections.sort(res);
        return res;
    }
    
    private void dfs(int[][] maze, int n, int i, int j, boolean[][] visited, StringBuilder path, ArrayList<String> res) {
        // If destination is reached
        if (i == n - 1 && j == n - 1) {
            res.add(path.toString());
            return;
        }
        
        // Mark as visited
        visited[i][j] = true;
        
        // Directions in lexicographical order: D, L, R, U
        int[] di = {1, 0, 0, -1};
        int[] dj = {0, -1, 1, 0};
        char[] dir = {'D', 'L', 'R', 'U'};
        
        for (int k = 0; k < 4; k++) {
            int ni = i + di[k];
            int nj = j + dj[k];
            
            if (isSafe(ni, nj, maze, visited, n)) {
                path.append(dir[k]);
                dfs(maze, n, ni, nj, visited, path, res);
                path.deleteCharAt(path.length() - 1); // backtrack
            }
        }
        
        // Unmark visited before backtracking
        visited[i][j] = false;
    }
    
    private boolean isSafe(int i, int j, int[][] maze, boolean[][] visited, int n) {
        return i >= 0 && j >= 0 && i < n && j < n && maze[i][j] == 1 && !visited[i][j];
    }
}
