class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 =new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while(l1!=null){
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while(l2!=null){
            stack2.push(l2.val);
            l2 = l2.next;
        }

        ListNode head = null;
        ListNode temp = null;
        int carry = 0;

        while(!stack1.empty() || !stack2.empty() || carry!=0){
            int top1 = stack1.empty() ? 0 : stack1.pop();
            int top2 = stack2.empty() ? 0 : stack2.pop();

            int sum = top1 + top2 + carry;
            carry = sum / 10;
            int res = sum % 10;

            ListNode newNode = new ListNode(res);
            newNode.next = head;
            head = newNode;
        }

        return head;
    }
}