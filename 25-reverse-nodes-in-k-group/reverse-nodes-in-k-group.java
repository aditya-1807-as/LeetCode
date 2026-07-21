class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode groupPrev = dummy;

        while (true) {
            
            // Find kth node
            ListNode kth = groupPrev;
            
            for (int i = 0; i < k; i++) {
                kth = kth.next;
                
                // Less than k nodes remaining
                if (kth == null) {
                    return dummy.next;
                }
            }

            // Node after the current group
            ListNode groupNext = kth.next;

            // Reverse the current group
            ListNode prev = groupNext;
            ListNode curr = groupPrev.next;

            while (curr != groupNext) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            // Connect previous group with reversed group
            ListNode temp = groupPrev.next;
            groupPrev.next = kth;

            // Move groupPrev to the end of reversed group
            groupPrev = temp;
        }
    }
}