/*
Problem Description
Given an array of integers A.

value of a array = max(array) - min(array).

Calculate and return the sum of values of all possible subarrays of A modulo 109+7.



Problem Constraints
1 <= |A| <= 100000

1 <= A[i] <= 1000000

Solution Approach

 */
package Stack;

public class MAX_MIN {
    public int solve(int[] A) {
        int N=A.length;
        int mod=(int)1e9+7;

        int[] arrMinLeft=getLeftArray(A,false);
        int[] arrMinRight=getRightArray(A,false);
        int[] arrMaxLeft=getLeftArray(A,true);
        int[] arrMaxRight=getRightArray(A,true);

        int[] arrMin=new int[N];
        long ans=0;
        for(int i=0;i<N;i++){
            //Element*occurance and max element * occurance as min element
            //occurance as max element Left P=i-(leftMax+1)+1==i-leftMax
            //occurance as max element Right Q=rightMax-1-i+1==rightMax-i
            //Total as max element=P+Q
            //occurance as min element Left X=i-(leftMin+1)+1==i-leftMin
            //occurance as min element Right Y=rightMin-1-i+1==rightMin-i
            //Total as min element=X+Y
            long P=i-arrMaxLeft[i];
            long Q=arrMaxRight[i]-i;
            long X=i-arrMinLeft[i];
            long Y=arrMinRight[i]-i;
            ans+=((A[i])%mod*(((P+Q)-(X+Y)))%mod)%mod;
            ans%=mod;
        }
        return (int)ans;

    }

    int[] getLeftArray(int[] arr,boolean IsGetMax){
        int N=arr.length;
        int[] ans=new int[N];
        Stc stack=new Stc(N);
        //System.out.println("getLeftArray");
        for(int i=0;i<N;i++){
            if(IsGetMax){
                while(!stack.isEmpty() && arr[stack.peek()]<=arr[i]){
                    stack.pop();//remove if top of stack is smaller
                }
            }
            else
            {
                while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){// 4>=7
                    stack.pop();//remove if top of stack is greater
                }
            }

            if(stack.isEmpty())//[-1,0]  [0
                ans[i]=-1;
            else
                ans[i]=stack.peek();
            //System.out.println(ans[i]);
            stack.push(i);
        }
        return ans;
    }

    int[] getRightArray(int[] arr,boolean IsGetMax){
        int N=arr.length;
        int[] ans=new int[N];
        Stc stack=new Stc(N);
        //System.out.println("getRightArray");
        for(int i=N-1;i>=0;i--){
            if(IsGetMax){
                while(!stack.isEmpty() && arr[stack.peek()]<=arr[i]){
                    stack.pop();//remove if top of stack is smaller
                }
            }
            else
            {
                //i=1,A[i]=7,
                while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){// 3>=7
                    stack.pop();//remove if top of stack is greater
                }
            }

            if(stack.isEmpty())//[2,2,-1,-1]  //[2
                ans[i]=N;
            else
                ans[i]=stack.peek();
            //System.out.println(ans[i]);
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
