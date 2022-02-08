/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode head1, ListNode head2) {
        if(head1==null || head2==null)
            return null;
        int count1= countNodes(head1);
        int count2=countNodes(head2);
        
        if(count1>count2){
            int diff=count1-count2;
            while(diff>0 && head1!=null){
                head1=head1.next;
                diff--;
            }
        }
        else if(count2>count1){
            int diff=count2-count1;
            while(diff>0 && head2!=null){
                head2=head2.next;
                diff--;
            }
        }
        
        while(head1!=null && head2!=null){
            if(head1==head2){
                return head1;
            }
            head1=head1.next;
            head2=head2.next;
        }
        return null;
    }
    
    public int countNodes(ListNode head){
        if(head==null)
            return 0;
        int count=0;
        while(head!=null){
            count++;
            head=head.next;
        }
        return count;
    }
}