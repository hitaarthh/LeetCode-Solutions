class Solution {
    public int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        
        int maxSum = 0;
        while (slow != null) {
            maxSum = Math.max(maxSum, slow.val + prev.val);
            slow = slow.next;
            prev = prev.next;
        }
        
        return maxSum;
    }
}