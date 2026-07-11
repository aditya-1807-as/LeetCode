// class Solution {

//     public int shipWithinDays(int[] weights, int days) {

//         int low = 0;
//         int high = 0;

//         for (int w : weights) {
//             low = Math.max(low, w);
//             high += w;
//         }

//         for (int capacity = low; capacity <= high; capacity++) {

//             if (canShip(weights, days, capacity)) {
//                 return capacity;
//             }
//         }

//         return -1;
//     }

//     private boolean canShip(int[] weights,
//                             int days,
//                             int capacity) {

//         int currentWeight = 0;
//         int requiredDays = 1;

//         for (int w : weights) {

//             if (currentWeight + w <= capacity) {

//                 currentWeight += w;

//             } else {

//                 requiredDays++;
//                 currentWeight = w;

//             }
//         }

//         return requiredDays <= days;
//     }
// }

class Solution {

    public int shipWithinDays(int[] weights, int days) {

        int low = 0;
        int high = 0;

        for (int w : weights) {
            low = Math.max(low, w);
            high += w;
        }

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (canShip(weights, days, mid)) {

                high = mid;

            } else {

                low = mid + 1;

            }

        }

        return low;
    }

    private boolean canShip(int[] weights,
                            int days,
                            int capacity) {

        int currentWeight = 0;
        int requiredDays = 1;

        for (int w : weights) {

            if (currentWeight + w <= capacity) {

                currentWeight += w;

            } else {

                requiredDays++;
                currentWeight = w;

            }

        }

        return requiredDays <= days;
    }
}