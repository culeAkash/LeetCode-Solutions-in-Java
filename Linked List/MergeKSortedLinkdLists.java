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
    public ListNode mergeKLists(ListNode[] arr) {
        if(arr.length==0)
            return null;
        int k = arr.length;
        
        PriorityQueue<ListNode> pq = new PriorityQueue<>((o1,o2) -> o1.val-o2.val);
        
        for(int i=0;i<k;i++){
            if(arr[i]!=null)
            pq.offer(arr[i]);
        }
        
        ListNode head = null;
        ListNode tail = null;
        while(!pq.isEmpty()){
            ListNode top = pq.poll();
            if(head==null){
                head = top;
                tail = top;
            }
            else{
                tail.next = top;
                tail = tail.next;
            }
            if(top.next!=null)
                pq.add(top.next);
        }
        return head;
    }
}