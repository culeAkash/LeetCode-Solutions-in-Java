class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null)
            return head;
        
        ListNode evenHead=null,evenTail=null,oddHead=null,oddTail=null;
        int index=1;
        while(head!=null){
        if(index%2==0){
            if(evenHead==null){
                evenHead=head;
                evenTail=head;
            }
            else{
                evenTail.next=head;
                evenTail=evenTail.next;
            }
        }
        else{
            if(oddHead==null){
                oddHead=head;
                oddTail=head;
            }
            else{
                oddTail.next=head;
                oddTail=oddTail.next;
            }
        }
        count++;
            head=head.next;
    }

    if(oddHead==null)
    return evenHead;//if odd LL is empty

    oddTail.next=evenHead;
    if(evenHead!=null)//if even LL is not null it tail must point to null
    evenTail.next=null;
    return oddHead;
    }
}