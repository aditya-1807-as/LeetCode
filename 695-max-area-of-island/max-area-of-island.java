
class Solution {

    public int maxAreaOfIsland(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int maxArea = 0;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 1) {

                    int area = dfs(grid, i, j);

                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int r, int c) {

        // Boundary and water check
        if (r < 0 || c < 0 ||
            r >= grid.length ||
            c >= grid[0].length ||
            grid[r][c] == 0) {

            return 0;
        }

        // Mark visited
        grid[r][c] = 0;

        // Count current cell + connected cells
        int area = 1;

        area += dfs(grid, r + 1, c); // Down
        area += dfs(grid, r - 1, c); // Up
        area += dfs(grid, r, c + 1); // Right
        area += dfs(grid, r, c - 1); // Left

        return area;
    }
}
