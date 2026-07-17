class Solution {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode prev = head;
        ListNode curr = head.next;
        int groupSize = 2;

        while (curr != null) {

            // Find actual length of current group
            int count = 0;
            ListNode temp = curr;

            while (count < groupSize && temp != null) {
                temp = temp.next;
                count++;
            }

            if (count % 2 == 0) {
                // Reverse 'count' nodes
                ListNode groupStart = curr;
                ListNode reversePrev = temp;
                ListNode node = curr;

                for (int i = 0; i < count; i++) {
                    ListNode next = node.next;
                    node.next = reversePrev;
                    reversePrev = node;
                    node = next;
                }

                // Connect previous group
                prev.next = reversePrev;

                // groupStart is now the last node
                prev = groupStart;
                curr = temp;

            } else {
                // Don't reverse
                for (int i = 0; i < count; i++) {
                    prev = curr;
                    curr = curr.next;
                }
            }

            groupSize++;
        }

        return head;
    }
}