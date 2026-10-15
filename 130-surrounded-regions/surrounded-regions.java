
class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        // Check first and last columns
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }

        // Check first and last rows
        for (int j = 0; j < n; j++) {
            dfs(board, 0, j);
            dfs(board, m - 1, j);
        }

        // Capture surrounded O's and restore safe cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        int m = board.length;
        int n = board[0].length;

        if (r < 0 || c < 0 || r >= m || c >= n
                || board[r][c] != 'O') {
            return;
        }

        // Mark boundary-connected O as safe
        board[r][c] = '#';

        dfs(board, r + 1, c); // Down
        dfs(board, r - 1, c); // Up
        dfs(board, r, c + 1); // Right
        dfs(board, r, c - 1); // Left
    }
}
