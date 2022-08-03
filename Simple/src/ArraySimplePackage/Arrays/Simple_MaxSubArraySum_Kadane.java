/*
Problem Description
Find the contiguous non-empty subarray within an array, A of length N, with the largest sum.



Problem Constraints
1 <= N <= 1e6
-1000 <= A[i] <= 1000

Solution approach
|===> Keep adding if you get max value
*if if sum gets -ive make it zero*
 */
package ArraySimplePackage.Arrays;

public class Simple_MaxSubArraySum_Kadane {
    public int maxSubArray(final int[] A) {
        int maxSum=Integer.MIN_VALUE;
        //int subArraySum=0;
        int subArraySum=0;
        for(int i=0;i<A.length;i++){

            //for(int j=i;j<A.length;j++){
            subArraySum+=A[i];
            //}
            if(subArraySum>maxSum)
                maxSum=subArraySum;
            if(subArraySum < 0)
                subArraySum=0;
        }
        return maxSum;
    }
}
