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
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null){
            return true;
        }
        
        ArrayList<Integer> nodes= new ArrayList<>();
        
        while(head!=null){
            nodes.add(head.val);
            head=head.next;
        }
        
        int start=0;
        int end= nodes.size()-1;
        
        while(start<=end){
            if(nodes.get(start)!=nodes.get(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}