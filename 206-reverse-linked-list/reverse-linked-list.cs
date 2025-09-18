/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * }  1->2->3
   ^  *  n

 */
public class Solution {
    public ListNode ReverseList(ListNode head) {
        ListNode prev=null;
        ListNode cur=head;
        while(cur!=null)
        {
            
            ListNode next=cur.next;
            cur.next=prev;// 1<-2  3
            //prev.next=cur; how to make first element point to null
            prev=cur;
            cur=next;
            
        }
        return prev;
    }
}