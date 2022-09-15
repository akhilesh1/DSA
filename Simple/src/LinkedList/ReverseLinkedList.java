/*
Need to break the link and reverse it
Just need a temp pointer to keep track of node to be broken
 */
package LinkedList;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode A) {
        ListNode p=null;
        ListNode cur=A;
        while(cur!=null)
        {
            ListNode temp=cur.next;
            cur.next=p;
            p=cur;
            cur=temp;
        }
        return p;
    }
}
