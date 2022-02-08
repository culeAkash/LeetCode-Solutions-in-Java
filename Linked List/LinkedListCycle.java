public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null)
            return false;
        
        HashMap<ListNode,Boolean> map= new HashMap<>();
        
        while(head!=null){
            if(map.containsKey(head))
                return true;
            map.put(head,true);
            head=head.next;
        }
        return false;
    }
}