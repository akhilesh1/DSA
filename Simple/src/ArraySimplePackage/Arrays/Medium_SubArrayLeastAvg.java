/*
#Subarray with least average Get Start Index#
Problem Description
Given an array of size N, find the subarray of size K with the least average.



Problem Constraints
1<=k<=N<=1e5
-1e5<=A[i]<=1e5


Input Format
First argument contains an array A of integers of size N.
Second argument contains integer k.


Output Format
*Return the index of the first element of the subarray* of size k that has least average.
Array indexing starts from 0.

Solution Approach
1)Using sliding window calculate only sum of each window *(No need to calculate avg)* and store in an array
2)Traverse the array and get the required index
 */
package ArraySimplePackage.Arrays;

public class Medium_SubArrayLeastAvg {
    public int solve(int[] A, int B) {

        int[] arr=new int[A.length-B+1];//Mistake 1
        int beforeSum=0;
        for(int i=0;i<B;i++){
            beforeSum+=A[i];
        }


        arr[0]=beforeSum;
        for(int i=B;i<A.length;i++){
            beforeSum+=A[i];
            beforeSum-=A[i-B];
            int avg=beforeSum;
            arr[i-B+1]=avg;
        }
        int leastSum=Integer.MAX_VALUE;
        int resultLength=-1;
        for(int i=0;i<arr.length;i++){
            if(leastSum>arr[i]){
                resultLength=i;
                leastSum=arr[i];//Mistake 2
            }
        }
        return resultLength;
    }
}
