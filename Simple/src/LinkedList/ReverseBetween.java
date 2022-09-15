/*
Keep track of 4 pointers
1)start 2)end 3)startJoint(just before start) 4)endJoint(just after end)

get all 4 above by simple traversal
 then break the chain between end and end joint
 Make a reverse by reverse function
 join again
 Notice

 if start joint is null start will be head of the ans

*/

package LinkedList;

public class ReverseBetween {
    public ListNode reverseBetween(ListNode A, int B, int C) {
        int pos=1;
        if(A==null)
            return null;
        if(A.next==null)
            return A;
        //###
        //Get start index of target LL
        ListNode cur=A;
        ListNode startJoint=null;
        while(pos<B && cur!=null)
        {
            startJoint=cur;
            cur=cur.next;
            pos++;
        }
        ListNode start=cur;
        //###
        //Get end index of target LL
        //cur=cur.next;
        while(pos<C && cur!=null)
        {
            cur=cur.next;
            pos++;
        }
        ListNode end=cur;
        ListNode endJoint=end.next;//handle null condn
        end.next=null;//break after
        //Reverse B-->C

        ListNode reversedHead=reverseList(start);

        start.next=endJoint;
        if(startJoint!=null)
            startJoint.next=reversedHead;
        else
            A=reversedHead;
        return A;
    }
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
