// import java.util.Collections;
// import java.util.PriorityQueue;

// class Solution {
//     public int lastStoneWeight(int[] stones) {
//         PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

//         // Add all stones to the max heap
//         for (int stone : stones) {
//             maxHeap.offer(stone);
//         }

//         // Smash the two largest stones
//         while (maxHeap.size() > 1) {
//             int first = maxHeap.poll();
//             int second = maxHeap.poll();

//             if (first != second) {
//                 maxHeap.offer(first - second);
//             }
//         }

//         return maxHeap.isEmpty() ? 0 : maxHeap.poll();
//     }
// }
class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());

        for (int stone : stones) {
            pq.add(stone);
        }

        while (pq.size() > 1) {

            int a = pq.poll();  // heaviest
            int b = pq.poll();  // second heaviest

            if (a != b) {
                pq.add(a - b);
            }
        }

        return pq.isEmpty() ? 0 : pq.peek();
    }
}