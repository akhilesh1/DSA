/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int val=0, ListNode next=null) {
 *         this.val = val;
 *         this.next = next;
 *     }
 * } L1->1->2->4

     L2->1->3->4


 */
public class Solution {
    public ListNode MergeTwoLists(ListNode list1, ListNode list2) {
        //L1->1->2->4

        //L2->1->3->4
        ListNode l1=list1;
        ListNode l2=list2;

        if(l1==null) return l2;
        if(l2==null) return l1;


        ListNode head=new();
        if(l1.val<=l2.val)
        {
            head=l1;
            l1=l1.next;
        }
        else
        {
            head=l2; 
            l2=l2.next;
        }

        ListNode cur=head;
        while(l1!=null && l2!=null)
        {
            if(l1.val<l2.val)
            {
                cur.next=l1;
                l1=l1.next;
            }
            else
            {
                cur.next=l2;
                l2=l2.next;
            }
            cur = cur.next;
        }
        if(l1!=null)
        {
            cur.next=l1;
        }
        else
            cur.next=l2;   

        return head;
    }
}