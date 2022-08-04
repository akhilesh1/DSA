/*

*Closest MinMax*
Problem Description
Given an array A, find the size of the smallest subarray such that it contains at least one occurrence of the maximum value of the array

and at least one occurrence of the minimum value of the array.



Problem Constraints
1 <= |A| <= 2000
Solution Approach
eg. A=[1 1 1 9 9] answer should be 2
this is a two step approach
1)Get min and max value out of array by completely traversing it.
2)traverse again and Get the indexes i and j where we get the min and max item
and check if its distance  <already existing distance(whole array length)

 */
package Arrays.All;

public class Medium_ClosestMinMax {
    public int solve(int[] A) {
        //1)Find Min max values
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++){
            min=Math.min(A[i],min);
            max=Math.max(A[i],max);
        }
        if(min==max)
            return 1;
        int minIndex=-1;
        int maxIndex=-1;
        int distance=A.length;
        //traverse and check if current
        for(int i=0;i<A.length;i++){
            if(A[i]==max ){
                maxIndex=i;
            }
            else if (A[i]==min){
                minIndex=i;
            }
            if(minIndex>-1 && maxIndex>-1 && distance>Math.abs(minIndex-maxIndex)+1)
                distance=Math.abs(minIndex-maxIndex)+1;
        }
        return distance;
    }
}
