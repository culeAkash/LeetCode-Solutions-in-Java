class Solution {
    public ListNode mergeNodes(ListNode head) {
        if(head==null || head.next==null)
            return null;
        
        ListNode newHead=null,tail=null;
        
        ListNode node= head.next;
        
        while(node!=null){
            int sum=0;
            while(node.val!=0){
                sum+=node.val;
                node=node.next;
            }
            
            ListNode newNode= new ListNode(sum);
            if(newHead==null){
                newHead= newNode;
                tail=newHead;
            }
            else{
                tail.next=newNode;
                tail=tail.next;
            }
            node=node.next;
        }
        return newHead;
    }
}