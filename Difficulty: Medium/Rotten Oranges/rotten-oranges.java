import java.util.*;

class Solution {
    public int orangesRotting(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        
        // Step 1: Count fresh oranges and push all rotten ones to queue
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(mat[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
                else if(mat[i][j] == 1) {
                    fresh++;
                }
            }
        }
        
        // If no fresh oranges, return 0 immediately
        if(fresh == 0) return 0;
        
        int time = -1; // track minutes
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        
        // Step 2: BFS
        while(!q.isEmpty()) {
            int size = q.size();
            time++;
            
            for(int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int x = cur[0], y = cur[1];
                
                for(int[] d : dirs) {
                    int nx = x + d[0], ny = y + d[1];
                    
                    if(nx >= 0 && ny >= 0 && nx < n && ny < m && mat[nx][ny] == 1) {
                        mat[nx][ny] = 2; // rot it
                        fresh--;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        
        // If still fresh oranges left → impossible
        return (fresh == 0) ? time : -1;
    }
}
