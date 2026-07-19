/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        HashMap<Integer, ListNode> map = new HashMap<>();

        int prefixSum = 0;

        // First pass: store LAST node for every prefix sum
        for (ListNode curr = dummy; curr != null; curr = curr.next) {
            prefixSum += curr.val;
            map.put(prefixSum, curr);
        }

        prefixSum = 0;

        // Second pass: skip zero-sum sequences
        for (ListNode curr = dummy; curr != null; curr = curr.next) {
            prefixSum += curr.val;
            curr.next = map.get(prefixSum).next;
        }

        return dummy.next;
    }
}