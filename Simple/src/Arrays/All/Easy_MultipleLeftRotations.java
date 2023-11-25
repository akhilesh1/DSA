/*
Problem Description
Given an array of integers A and multiple values in B, which represents the number of times array A needs to be left rotated.

Find the rotated array for each value and return the result in the from of a matrix where ith row represents the rotated array for the ith value in B.

Input 1:
    A = [1, 2, 3, 4, 5]
    B = [2, 3]
Input 2:
    A = [5, 17, 100, 11]
    B = [1]
    
Output 1: 
    [ [3, 4, 5, 1, 2]
     [4, 5, 1, 2, 3] ]
Output 2:
    [ [17, 100, 11, 5] ]


Problem Constraints
1 <= length of both arrays <= 2000 -10^9 <= A[i] <= 10^9 0 <= B[i] <= 2000

Solution Approach
Rotation we dont know but we know reverse very well, so we will utilize this trick of
Full reverse + reverse at another end
if no of rotations are > elments in array => rotations= rotations%elements count;
 */
package Arrays.All;

public class Easy_MultipleLeftRotations {
    public  int[][] solve(int[] A, int[] B) {
        int[][] arr2d=new int[B.length][A.length];
        for(int i=0;i<B.length;i++){
            int[] R=LeftRotate(A,B[i]%A.length);
            arr2d[i]=R.clone();
        }
        return arr2d;
    }

    public  int[] LeftRotate(int[] arr,int rotations){
        int[] A=arr.clone();
        A=Reverse(A,0,arr.length-1);
        A=Reverse(A,0,arr.length-rotations-1);
        A=Reverse(A,arr.length-rotations,arr.length-1);

        return A;
    }

    public  int[] Reverse(int[] arr,int i,int j){
        int[] A=arr;
        while(i<j){
            A[i]=A[i]+A[j];
            A[j]=A[i]-A[j];
            A[i]=A[i]-A[j];
            i++;
            j--;
        }
        return A;
    }
}
