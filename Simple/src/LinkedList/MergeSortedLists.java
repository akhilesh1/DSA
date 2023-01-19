package LinkedList;


// * Definition for singly-linked list.
 class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
 }

public class MergeSortedLists {
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
                //1)Assign value
                tail.next=A;
                //2)Move Forward
                tail=tail.next;
                A=A.next;

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
