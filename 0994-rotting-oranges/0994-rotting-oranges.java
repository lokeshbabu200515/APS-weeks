import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        
        // Step 1: Add all rotten oranges to queue & count fresh
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        
        // Directions (up, down, left, right)
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
        int minutes = 0;
        
        // Step 2: BFS
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                
                for (int[] d : directions) {
                    int r = curr[0] + d[0];
                    int c = curr[1] + d[1];
                    
                    // Check bounds & fresh orange
                    if (r >= 0 && r < rows && c >= 0 && c < cols && grid[r][c] == 1) {
                        grid[r][c] = 2; // rot it
                        queue.add(new int[]{r, c});
                        fresh--;
                    }
                }
            }
            
            minutes++;
        }
        
        return (fresh == 0) ? minutes : -1;
    }
}