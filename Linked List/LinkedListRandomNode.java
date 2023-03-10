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

    ListNode head;
    int length = 0; 
    
    public Solution(ListNode node) {
        head = node;
        length = 0;
        ListNode temp = head;
        while(temp!=null){
            temp = temp.next;
            length++;
        }    
    }
    
    public int getRandom() {
        int rand = (int)(Math.random()*length);

        // int res = 0;
        ListNode temp = head;
        for(int i=0;i<rand;i++){
            temp = temp.next;
        }
        return temp.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */