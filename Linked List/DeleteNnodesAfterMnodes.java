public class Solution {
	public static Node<Integer> getListAfterDeleteOperation(Node<Integer> head, int n, int m) {
		 if(head==null){
            return head;
        }

        Node<Integer> newHead=null,newTail=null;
        while(head!=null){
            int count=m;
            while(count>0 && head!=null){
                if(newHead==null){
                    newHead=head;
                    newTail=head;
                }
                else{
                    newTail.next=head;
                    newTail=newTail.next;
                }
                count--;
                head=head.next;
            }

            count=n;
            while(count>0 && head!=null){
                head=head.next;
                count--;
            }
        }

        if(newHead==null){
            return newHead;
        }

        newTail.next=null;
        return newHead;
	}
}