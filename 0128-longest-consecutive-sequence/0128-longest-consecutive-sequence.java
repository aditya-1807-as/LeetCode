// class Solution {
//     public int longestConsecutive(int[] nums) {

//         int longest = 0;

//         for (int i = 0; i < nums.length; i++) {

//             int current = nums[i];
//             int count = 1;

//             while (contains(nums, current + 1)) {
//                 current++;
//                 count++;
//             }

//             longest = Math.max(longest, count);
//         }

//         return longest;
//     }

//     private boolean contains(int[] nums, int target) {

//         for (int num : nums) {
//             if (num == target) {
//                 return true;
//             }
//         }

//         return false;
//     }
// }

class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int num : set) {

            // Start only if num is the beginning of a sequence
            if (!set.contains(num - 1)) {

                int current = num;
                int count = 1;

                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
}