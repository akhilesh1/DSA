package LinkedList;

public class AllOperations {
    public static class Node{
        int data;
        Node next;
        Node(int val){
            data=val;
            next=null;
        }
    }
    static Node head=null;
    static int length=1;
    public static void insert_node(int position, int value) {
        // @params position, integer
        // @params value, integer
        if(position>length+1)
            return;
        Node newNode=new Node(value);
        Node node=head;
        Node prev=null;
        int pos=1;
        if(position==1)
        {//head is null also catered here
            newNode.next=node;
            head=newNode;
        }
        else
        {
            while(node!=null && pos<position)
            {
                prev=node;
                node=node.next;
                pos++;
            }
            //System.out.println("size:"+length+":position"+position)  ;
            newNode.next=node.next;
            node.next=newNode;
        }
        length++;
    }

    public static void delete_node(int position) {
        // @params position, integer
        Node node=head;
        Node prev=null;
        int pos=1;
        if(node==null || position>length+1)
            return;
        if(pos==1){
            head=head.next;
        }
        else
        {
            while(node!=null && pos<position-1)
            {
                pos++;
                //prev=node;
                node=node.next;
            }
            node.next=node.next.next;
        }


        length--;
    }

    public static void print_ll() {
        // Output each element followed by a space
        Node node=head;
        while(node.next!=null)
        {
            System.out.print(node.data+" ");
            node=node.next;
        }
        System.out.print(node.data);
    }


}
