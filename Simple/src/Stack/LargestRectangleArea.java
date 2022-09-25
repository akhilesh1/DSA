/*
Given an array of integers A.

A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.

Find the area of the largest rectangle formed by the histogram.



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 1000000000

Solution Approach:
 //TRICK: .|-^-|.   ^ IS current element and . is next smaller elements in left and right
            //In LEFT one element after . | and in RIGHT one element before |.
            //Area= distance b/w both |  * ith value^
Create 2 Arrays
one for index of next smaller element on the left
one for index of next smaller element on the right
actualIndexLeft=indexLeft+1
actualIndexRight=indexRight-1
then area = (actualIndexRight-actualIndexLeft+1)*A[i]
 */
package Stack;

public class LargestRectangleArea {
    public int largestRectangleArea(int[] A) {
        int N=A.length;
        int ans=A[0];
        if(N==1)
            return A[0];
        int[] firstSmallerLeft=getFirstSmallerLeft(A);
        int[] firstSmallerRight=getFirstSmallerRight(A);
        for(int i=0;i<N;i++){
            //TRICK: .|-^-|.   ^ IS current element and . is next smaller elements in left and right
            //In LEFT one element after . | and in RIGHT one element before |.
            //Area= distance b/w both |  * ith value^
            int currentArea = (firstSmallerRight[i]-(firstSmallerLeft[i]+1))*A[i];
            ans = Math.max(currentArea,ans);
        }
        return ans;
    }
    int[] getFirstSmallerLeft(int[] arr){
        int N=arr.length;
        int[] ans=new int[N];
        Stc stack=new Stc(N);
        //System.out.println("getFirstSmallerLeft");
        for(int i=0;i<N;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();//remove if top of stack is any greater
            }

            if(stack.isEmpty())
                ans[i]=-1;
            else
                ans[i]=stack.peek();

            stack.push(i);
            //System.out.println(ans[i]);
        }
        return ans;
    }
    int[] getFirstSmallerRight(int[] arr){
        int N=arr.length;
        int[] ans=new int[N];
        Stc stack=new Stc(N);
        //System.out.println("getFirstSmallerRight");
        for(int i=N-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();//remove if top of stack is any greater
            }

            if(stack.isEmpty())
                ans[i]=N;
            else
                ans[i]=stack.peek();

            stack.push(i);
            //System.out.println(ans[i]);
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
