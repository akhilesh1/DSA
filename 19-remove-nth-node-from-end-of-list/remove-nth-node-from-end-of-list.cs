/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }
 */
public class Solution {
    public ListNode RemoveNthFromEnd(ListNode head, int n) {
       
        //get items count N
        //reach N-(n-1) 
        //do next next
        int N=0;
        ListNode cur=head;
        ListNode temp=head;
        while(cur!=null)
        {
            cur=cur.next;
            N++;
        }

        
        int i=0;
        if(N==n)
            return head.next;

        while(temp!=null && i<(N-n-1))
        {
            i++;
            temp=temp.next;
        }
        if(temp.next==null)
            head=null;
        else
            temp.next=temp.next.next;

        return head;
    }
}