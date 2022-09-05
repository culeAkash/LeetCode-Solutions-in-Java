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
    int count = 0;
    public int[] nextLargerNodes(ListNode head) {
        head = reverse(head);
        
        int[] ans = new int[count];
        
        Stack<Integer> stack = new Stack<>();
        int i =count-1;
        while(head!=null){
                while(!stack.empty() && stack.peek()<=head.val)
                    stack.pop();
                
            if(stack.empty())
                ans[i--] = 0;
            else
                ans[i--] = stack.peek();
            
            stack.push(head.val);
            head = head.next;
                
            }
        return ans;
        }
    
    
    public ListNode reverse(ListNode head){
        if(head==null)
            return head;
        
        ListNode prev = null, nextNode = head;
        
        while(head!=null){
            count++;
            nextNode = head.next;
            head.next = prev;
            prev = head;
            head = nextNode;
        }
        return prev;
    }
}