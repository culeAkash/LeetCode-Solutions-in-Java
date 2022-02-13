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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null)
            return head;
        
        int count=0;
        ListNode t= head;
        while(t!=null){
            count++;
            t=t.next;
        }
        
        count=count/k;//No. of reversals
        ListNode newHead=null,newTail=null,tail=head;
        while(count>0){
            int l=k;
            while(l>1){
                tail=tail.next;
                l--;
            }
            ListNode temp1= tail.next;
            tail.next=null;
            Pair temp= reverse(head,tail);
            
            if(newHead==null){
                newHead=temp.head;
                newTail=temp.tail;
            }
            else{
                newTail.next=temp.head;
                newTail=temp.tail;
            }
            
            newTail.next=temp1;
            head=temp1;
            tail=head;
            count--;
        }
        return newHead;
    }
    
    Pair reverse(ListNode head,ListNode tail){
        if(head==null || head.next==null)
            return new Pair(head,tail);
        
        tail=head;
        ListNode prev=null,nextNode=null;
        while(head!=null){
            nextNode=head.next;
            head.next=prev;
            prev=head;
            head=nextNode;
        }
        return new Pair(prev,tail);
    }
}

class Pair{
    ListNode head;
    ListNode tail;
    
    Pair(ListNode h,ListNode t){
        head=h;
        tail=t;
    }
}