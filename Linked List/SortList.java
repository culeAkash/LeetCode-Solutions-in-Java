class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)
            return head;

        ListNode fast = head;
        ListNode slow = null;

        while(fast!=null && fast.next!=null){
            slow = slow==null ? fast : slow.next;
            fast = fast.next.next;
        }

        ListNode l1 = sortList(slow.next);
        slow.next=null;
        ListNode l2 = sortList(head);

        return mergeList(l2,l1);
    }

    public ListNode mergeList(ListNode l1,ListNode l2){
        ListNode head = null;
        ListNode tail = null;

        while(l1!=null && l2!=null){
            if(head==null){
                if(l1.val <= l2.val){
                    head = l1;
                    tail = l1;
                    l1=l1.next;
                }
                else{
                    head = l2;
                    tail = l2;
                    l2 = l2.next;
                }
            }
            else{
                if(l1.val<=l2.val){
                    tail.next = l1;
                    tail = l1;
                    l1 = l1.next;
                }
                else{
                    tail.next = l2;
                    tail = l2;
                    l2 = l2.next;
                }
            }
        }

        if(l1!=null){
            tail.next = l1;
        }

        if(l2!=null){
            tail.next = l2;
        }

        return head;
    }
}