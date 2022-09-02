/*
Problem Description
Given an array, A of integers of size N. Find the maximum value of j - i such that A[i] <= A[j].



Problem Constraints
1 <= N <= 105

-109 <= A[i] <= 109
Solution approach
Traverse and keep max index
keep calculating maximum ans by maxIndex-currentIndex
 */
package Sorting;
import java.util.Arrays;
public class MaxDistance {
    public int maximumGap(final int[] A) {
        int N=A.length;
        int[][] result=new int[N][2];
        for(int i=0;i<N;i++){
            result[i][0]=A[i];
            result[i][1]=i;
        }
        Arrays.sort(result,(int[] o1, int[] o2) -> o1[0] - o2[0]);
        int ans=0,maxItemIdx=result[N-1][1];
        for(int i=N-1;i>=0;i--){
            ans=Math.max(ans,maxItemIdx-result[i][1]);
            maxItemIdx=Math.max(maxItemIdx,result[i][1]);
        }
        return ans;
    }
}
