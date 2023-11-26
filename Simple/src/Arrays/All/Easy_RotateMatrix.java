/*
Problem Description
You are given a n x n 2D matrix A representing an image.

Rotate the image by 90 degrees (clockwise).

You need to do this in place.

Note: If you end up using an additional array, you will only receive partial score.



Problem Constraints
1 <= n <= 1000

Solution approach
Since this is a N*N matrix

Transpose + each row reverse
For transpose
Transpose is tricky you can not swap whole rows to columns, other wise same
need to only reverse bottom or upper triangle.

use the same anology to print diagnol in M*M matrix
since diagnol on 11,22,33,44 index
j should never go beyond i 

 */
package Arrays.All;

public class Solution {
    public void solve(int[][] A) {
        int r=A.length;
        int c=A[0].length;
        // bottom triangle
        for(int i=1;i<r;i++){
            for(int j=0;j<i;j++){
                int T=A[j][i];
                A[j][i]=A[i][j];
                A[i][j]=T;
            }
            
        }
        for(int i=0;i<A.length;i++){
            reverse(A[i]);
        }
    }
    public void reverse(int[] A){
        int i=0,j=A.length-1;
        while(i<j){
            A[i]=A[i]+A[j];
            A[j]=A[i]-A[j];
            A[i]=A[i]-A[j];
            i++;
            j--;
        }
        

    }
}
//Just in case you want to reverse upper triangle
 for(int i=0;i<r;i++){
    for(int j=i+1;j<c;j++){
        int T=A[j][i];
        A[j][i]=A[i][j];
        A[i][j]=T;
    }       
}
