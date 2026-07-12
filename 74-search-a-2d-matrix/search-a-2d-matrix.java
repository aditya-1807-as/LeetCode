// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {

//         for (int i = 0; i < matrix.length; i++) {
//             for (int j = 0; j < matrix[0].length; j++) {
//                 if (matrix[i][j] == target) {
//                     return true;
//                 }
//             }
//         }

//         return false;
//     }
// }

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {

            if (target >= matrix[i][0] && target <= matrix[i][cols - 1]) {

                int left = 0;
                int right = cols - 1;

                while (left <= right) {

                    int mid = left + (right - left) / 2;

                    if (matrix[i][mid] == target)
                        return true;

                    if (matrix[i][mid] < target)
                        left = mid + 1;
                    else
                        right = mid - 1;
                }
            }
        }

        return false;
    }
}