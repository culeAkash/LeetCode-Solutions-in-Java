/*Linked List Node
class LNode
{
    int data;
    LNode next;
    LNode(int d) {
        data = d; 
        next = null;
    }
}

//Tree Node
class TNode
{
    int data;
    TNode left, right;
    TNode(int x)
    {
        data=x;
        left=right=null;
    }
    
}*/

class Solution
{
    public TNode sortedListToBST(LNode head)
    {
        if(head==null)
            return null;
            
        if(head.next==null)
            return new TNode(head.data);
            
        LNode slow = head;
        LNode fast = head.next.next;
        
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        TNode node = new TNode(slow.next.data);
        
        
        node.right = sortedListToBST(slow.next.next);
        slow.next = null;
        node.left = sortedListToBST(head);
        return node;
        
    }
}