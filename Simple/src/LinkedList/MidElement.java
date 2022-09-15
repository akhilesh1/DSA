
/*
Solution appracoh fast pointer will tell what to do check when it is null and its next is null
 */
package LinkedList;

public class MidElement {
    public int solve(ListNode A)
    {
        ListNode cur1=A;
        ListNode cur2=A;
        //int i1=1,i2=1;
        while(cur2!=null && cur2.next!=null)//cur2.next!=null exists to avoid this check when we reach end of the list and cur2 become null
        {
            cur1=cur1.next;
            //System.out.println(cur1.val);
            cur2=cur2.next.next;
        }
        return cur1.val;
    }
}
