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
//Priority Queue Solution using O(N) extra space

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

//Solution using O(1) extra space using Merge Sort Algorithm
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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0)
            return null;

        return helper(lists,0,lists.length-1);
    }

    ListNode helper(ListNode[] lists,int start,int end){
        if(start==end)
            return lists[start];

        if(start+1==end)
            return merge(lists[start],lists[end]);

        int mid = (start + end)/2;

        ListNode left = helper(lists,start,mid);
        ListNode right = helper(lists,mid+1,end);

        return merge(left,right);
    }

    ListNode merge(ListNode left,ListNode right){
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;

        while(left!=null && right!=null){
            if(left.val<=right.val){
                head.next = left;
                left = left.next;
            }
            else{
                head.next = right;
                right = right.next;
            }
            head = head.next;
        }

        head.next = (left!=null)?left:right;

        return dummy.next;
    }
}
