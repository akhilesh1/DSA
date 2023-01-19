/*
Problem Description
Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers for a given array A of size N.

If such arrangement is not possible, it must be rearranged as the lowest possible order, i.e., sorted in ascending order.

NOTE:

The replacement must be in-place, do not allocate extra memory.
DO NOT USE LIBRARY FUNCTION FOR NEXT PERMUTATION. Use of Library functions will disqualify your submission retroactively and will give you penalty points.


Problem Constraints
1 <= N <= 5 * 105

1 <= A[i] <= 109

Solution Approach
eg 13542=>14532=>14 235  not
1)Get index I1= from the right get first element which is smaller than previous [4]
2)Get index I2=from right which element is greater than A[I1]=4 , 2
3)swap element at I1 I2 13524
4)reverse all elements which are right to I1

Corner case
A length 1 return
if I1 and I2 not valid do not do swap.
If already at last dictionary entry just reverse the whole string
 */
package Arrays.All;

import java.util.ArrayList;

public class Hard_NextPermutation {
    public ArrayList<Integer> nextPermutation(ArrayList<Integer> permutation) {
        // Write your code here.
        int N=permutation.size();
        if(N<=1)
            return permutation;
        //int prev=permutation.get(N-1);
        int x=-1;
        for(int i=N-2;i>=0;i--){
            if(permutation.get(i+1)>permutation.get(i)){
                x=i;
                break;
            }
        }
        if(x>-1){
            int y=-1;
            for(int i=N-1;i>=0;i--){
                if(permutation.get(i)>permutation.get(x))
                {
                    y=i;
                    break;
                }
            }
            if(y>-1)
                swap(permutation,x,y);
        }
        //System.out.println("x:"+x+"y:"+y);
        reverse(permutation,x+1,N-1);
        return permutation;
    }

    private void swap(ArrayList<Integer> permutation,int x,int y){
        int tempX=permutation.get(x);
        int tempY=permutation.get(y);
        permutation.set(y,tempX);
        permutation.set(x,tempY);
    }
    private void reverse(ArrayList<Integer> permutation,int start,int end){
        while(start<end){
            swap(permutation,start,end);
            start++;
            end--;
        }
    }
}
