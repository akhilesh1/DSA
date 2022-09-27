/*
Problem Description
Given an integer A, you have to find the Ath Perfect Number.

A Perfect Number has the following properties:

It comprises only 1 and 2.

The number of digits in a Perfect number is even.

It is a palindrome number.

For example, 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.



Problem Constraints
1 <= A <= 100000


Solution Approach
1, 2,   12, 22    ,121, 122

Items exists in pairs at a time we will keep only two integers in queue
------------------
Rear-->2,1-->Front
------------------

nextValue1=dequeue()*10+1; = 11
------------------
Rear-->11,2-->Front
------------------
    check for count if reach return rear
nextValue1=dequeue()*10+2; = 20+2=22
------------------
Rear-->22,11-->Front
------------------
    check for count if reach return rear

    Keep doing it
 */
package Queue;

public class PerfectNumbers {
    public String solve(int A)
    {
        if(A==1)
            return "11";
        if(A==2)
            return "22";

        myQ q=new myQ(A);
        long x=0;
        q.enQueue(1);
        q.enQueue(2);
        int cnt=2;
        while(cnt<A){
            int temp=q.deQueue();
            q.enQueue(temp*10+1);

            //hisab barabar one add one substract
            //now check if we reached the number
            cnt++;
            if(cnt==A)
            {
                x=q.rear();//Taking from rear only
                break;
            }

            q.enQueue(temp*10+2);
            cnt++;
            if(cnt==A)
            {
                x=q.rear();//Taking from rear only
                break;
            }
        }
        String ans=String.valueOf(x);
        return ans+new StringBuilder(ans).reverse().toString();
    }
    public class myQ{
        int[] arr;
        int front;
        int rear;
        myQ(int size)
        {
            front=0;
            rear=-1;
            arr=new int[size];
        }
        int front()
        {
            return arr[front];
        }
        int rear()
        {
            return arr[rear];
        }
        boolean isEmpty(){
            return front>rear;
        }
        public void enQueue(int x){
            rear++;
            arr[rear]=x;
        }
        public int deQueue(){
            if(isEmpty())
                return -1;
            int val=arr[front];
            front++;
            return val;
        }
    }
}
