/*
Problem Description
Given an array A, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.

More formally,

G[i] for an element A[i] = an element A[j] such that

j is maximum possible AND

j < i AND

A[j] < A[i]

Elements for which no smaller element exist, consider the next smaller element as -1.

Solution Approach:

 */
package Stack;

public class NearSmallerElement {
    public int[] prevSmaller(int[] A)
    {
        int[] minLeftArray = getLeftArray(A);
        for(int i=0;i<A.length;i++)
        {
            if(minLeftArray[i]!=-1)
                minLeftArray[i]=A[minLeftArray[i]];
        }
        return minLeftArray;
    }
    int[] getLeftArray(int[] arr){
        int N=arr.length;
        int[] ans=new int[N];
        Stc stack=new Stc(N);
        for(int i=0;i<N;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();//remove if top of stack is any greater
            }

            if(stack.isEmpty())
                ans[i]=-1;
            else
                ans[i]=stack.peek();

            stack.push(i);
        }
        return ans;
    }

    public class Stc
    {
        int [] arrSTC;
        public int top;
        Stc(int size)
        {
            arrSTC=new int[size];
            top=-1;
        }
        public boolean isEmpty(){
            return top==-1;
        }
        public int peek(){
            return arrSTC[top];
        }
        public void push(int value)
        {
            //if((top+1)<arrSTC.length)
            top++;
            arrSTC[top]=value;
        }
        public void pop()
        {
            if(top>-1)
            {
                arrSTC[top]=0;
                top--;
            }
        }
    }
}
