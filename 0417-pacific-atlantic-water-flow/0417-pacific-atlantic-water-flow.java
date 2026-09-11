import java.util.*;

class Solution {
    int m, n;
    int[][] heights;
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights = heights;
        m = heights.length;
        n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Pacific: top row + left column
        for (int j = 0; j < n; j++) {
            dfs(0, j, pacific);
        }

        for (int i = 0; i < m; i++) {
            dfs(i, 0, pacific);
        }

        // Atlantic: bottom row + right column
        for (int j = 0; j < n; j++) {
            dfs(m - 1, j, atlantic);
        }

        for (int i = 0; i < m; i++) {
            dfs(i, n - 1, atlantic);
        }

        List<List<Integer>> result = new ArrayList<>();

        // Cells reachable by both oceans
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int row, int col, boolean[][] visited) {
        if (visited[row][col]) {
            return;
        }

        visited[row][col] = true;

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newRow < m &&
                newCol >= 0 && newCol < n &&
                !visited[newRow][newCol] &&
                heights[newRow][newCol] >= heights[row][col]) {

                dfs(newRow, newCol, visited);
            }
        }
    }
}