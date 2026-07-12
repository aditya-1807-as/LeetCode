// class Solution {
//     public int[] findPeakGrid(int[][] mat) {

//         int m = mat.length;
//         int n = mat[0].length;

//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {

//                 boolean up = (i == 0) || mat[i][j] > mat[i - 1][j];
//                 boolean down = (i == m - 1) || mat[i][j] > mat[i + 1][j];
//                 boolean left = (j == 0) || mat[i][j] > mat[i][j - 1];
//                 boolean right = (j == n - 1) || mat[i][j] > mat[i][j + 1];

//                 if (up && down && left && right) {
//                     return new int[]{i, j};
//                 }
//             }
//         }

//         return new int[]{-1, -1};
//     }
// }


class Solution {

    public int[] findPeakGrid(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        int left = 0;
        int right = cols - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            int maxRow = 0;

            // Find maximum element in mid column
            for (int i = 1; i < rows; i++) {
                if (mat[i][mid] > mat[maxRow][mid]) {
                    maxRow = i;
                }
            }

            int leftValue = (mid > 0) ? mat[maxRow][mid - 1] : -1;
            int rightValue = (mid < cols - 1) ? mat[maxRow][mid + 1] : -1;

            if (mat[maxRow][mid] > leftValue &&
                mat[maxRow][mid] > rightValue) {

                return new int[]{maxRow, mid};
            }

            if (leftValue > mat[maxRow][mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return new int[]{-1, -1};
    }
}