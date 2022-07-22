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
    public ListNode partition(ListNode head, int x) {
        if(head==null || head.next==null)
            return head;
        
        List<ListNode> sm = new ArrayList<>();
        List<ListNode> lg = new ArrayList<>();
        
        while(head!=null){
            if(head.val<x)
                sm.add(head);
            else
                lg.add(head);
            ListNode temp = head;
            head=head.next;
            temp.next = null;
        }
        
        head = null;
        ListNode tail = null;
        for(int i=0;i<sm.size();i++){
            if(head==null){
                head = sm.get(0);
                tail = head;
            }
            else{
                tail.next = sm.get(i);
                tail = tail.next;
            }
        }
        
        for(int i=0;i<lg.size();i++){
            if(head==null){
                head = lg.get(0);
                tail = head;
            }
            else{
                tail.next = lg.get(i);
                tail = tail.next;
            }
        }
        
        return head;
        
    }
}


//O(N) Time and O(1) Space Solution

class Solution {
    public static Node partition(Node head, int x) {
        if(head==null || head.next==null)
        return head;
        
        Node smallHead=null,smallTail=null,largeHead=null,largeTail=null;
        Node midHead =null,midTail=null;
        
        while(head!=null){
            if(head.data<x){
                if(smallHead==null){
                    smallHead = head;
                    smallTail = head;
                }
                else{
                    smallTail.next = head;
                    smallTail = smallTail.next;
                }
            }
            else if(head.data>x){
                if(largeHead==null){
                    largeHead = head;
                    largeTail = head;
                }
                else{
                    largeTail.next = head;
                    largeTail = largeTail.next;
                }
            }
            else{
                if(midHead==null){
                    midHead = head;
                    midTail = head;
                }
                else{
                    midTail.next = head;
                    midTail = midTail.next;
                }
            }
            head= head.next;
        }
        
        //fix end of greatest list to null if this list has some nodes
        if(largeTail!=null)
            largeTail.next = null;
            
        //if smaller list is empty
        if(smallHead==null){
            if(midHead==null)
                return largeHead;
            midTail.next = largeHead;
            return midHead;
        }
        
        //if small list is not empty and mid list is empty
        if(midHead==null){
            smallTail.next = largeHead;
            return smallHead;
        }
        
        //if both small and mid list are not empty
        smallTail.next = midHead;
        midTail.next = largeHead;
        return smallHead;
        
        
        
        
    }
}