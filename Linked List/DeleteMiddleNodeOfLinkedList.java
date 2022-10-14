class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if(head.next==null)
            return null;
        ListNode fast = head;
        ListNode slow = null;
        while(fast!=null && fast.next!=null){
            slow = slow==null?fast:slow.next;
            fast = fast.next.next;
        }
        slow.next=slow.next.next;
        return head;
    }
}