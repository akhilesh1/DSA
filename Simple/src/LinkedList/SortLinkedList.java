package LinkedList;

public class SortLinkedList {

    public ListNode sortList(ListNode A)
    {
        if(A==null)
            return A;
        if(A.next==null)
            return A;

        ListNode mid=getMid(A);
        ListNode H1=A;
        ListNode H2=mid.next;//Imp  1 2 3 [4] *5 6 7  //Mid will be part of 1st LL not second LL
        mid.next=null;//break the chain so that H1 can not access elements beyond mid
        H1=sortList(H1);
        H2=sortList(H2);
        return mergeTwoLists(H1,H2);
    }

    public ListNode getMid(ListNode A)
    {
        ListNode f=A;//fast pointer 1 -> 2
        ListNode s=A;//slow pointer
        while(f.next!=null && f.next.next!=null){//imp while cond need first element in case of even
            f=f.next.next;
            s=s.next;
        }
        return s;
    }
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode head=null;
        //get head node
        if(A==null) return B;
        if(B==null) return A;
        //Means we have both not null
        if(A.val<B.val)
        {
            head=A;
            A=A.next;
        }
        else{
            head=B;
            B=B.next;//this is trick get head and forward pointer of head
        }
        //merge nodes
        ListNode tail=head;
        while(A!=null && B!=null)
        {
            if(A.val<B.val)
            {
                tail.next=A;
                A=A.next;
                tail=tail.next;
            }
            else
            {
                tail.next=B;
                B=B.next;
                tail=tail.next;
            }
        }
        //point to incomplete list
        if(A!=null)
            tail.next=A;
        else if(B!=null)
            tail.next=B;

        return head;
    }
}
