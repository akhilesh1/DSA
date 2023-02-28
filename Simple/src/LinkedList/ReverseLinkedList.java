/*
Need to break the link and reverse it
Just need a temp pointer to keep track of node to be broken


Stratagey in three steps

Step 1 cur node will store its next pointer for future in a variable NXT
Step 2 cur node is now free to perform operation to it will point back to Variable PREV
Step 3 move next and cur pointer to next location

Note since loop is terminating at c==nul so need to returning prev node not curent node.
 */
package LinkedList;


public class ReverseLinkedList {

    public ListNode reverseList(ListNode A) {
        ListNode cur=A;
        ListNode prev=null;
        while(cur!=null)
        {
            //Save next pointer
            ListNode nxt=cur.next;
            //Perform action of reverse
            cur.next=prev;
            //Move next(promote helper variable (prev) and self)
            prev=cur;
            cur=nxt;
        }
        return prev;
    }
}
