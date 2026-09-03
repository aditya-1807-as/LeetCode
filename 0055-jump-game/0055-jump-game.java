class Solution {
    public boolean canJump(int[] nums) {

        int farthest = 0;

        for (int i = 0; i < nums.length; i++) {

            // If current index is unreachable
            if (i > farthest) {
                return false;
            }

            // Update the farthest position we can reach
            farthest = Math.max(farthest, i + nums[i]);

            // We can already reach the last index
            if (farthest >= nums.length - 1) {
                return true;
            }
        }

        return true;
    }
}

// class Solution {
//     public boolean canJump(int[] nums) {
//         return solve(nums, 0);
//     }

//     private boolean solve(int[] nums, int index) {

//         // If we reached the last index
//         if (index >= nums.length - 1) {
//             return true;
//         }

//         // Try every possible jump
//         for (int jump = 1; jump <= nums[index]; jump++) {

//             if (solve(nums, index + jump)) {
//                 return true;
//             }
//         }

//         return false;
//     }
// }