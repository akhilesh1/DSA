/*
You are given a read only array of n integers from 1 to n.

Each integer appears exactly once except A which appears twice and B which is missing.

Return A and B.

Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Note that in your output A should precede B.

Example:

Input:[3 1 2 5 3]

Output:[3, 4]

A = 3, B = 4

Solution approach
we need to R-M and R+M to calcualte repeat and missing
R-M can be calculated as currentSum-IdealSum

(3+1+2+5+3)-(1+2+3+4+5) here non repeat and non missing
will cancel out each other
only R and M will remain.

for R+M we need 

R^2-M^2/R-M

r sq-m sq can be calculated 

as currentSumSquare-idealSumSquare

now you need to calculate currentSumSquare and idealSumSquare
 */
package Arrays.All;

public class Easy_RepeatAndMissing {
    public int[] repeatedNumber(final int[] A) {
        long N=A.length;
        long idealSum=(long)(N*(N+1)/2);
        long idealSumSquare=(long)(N*(N+1)*(2*N+1)/6);
        long currentSum=A[0],currentSumSquare=1l*A[0]*A[0];
        for(int i=1;i<N;i++){
            currentSum+=A[i];
            currentSumSquare+=(1L*A[i]*A[i]);
        }
        long RMinusM=currentSum-idealSum;
        long RSqMinusMSq=currentSumSquare-idealSumSquare;
        long RPlusM=(long)(RSqMinusMSq/RMinusM);
        int R=(int)((RMinusM+RPlusM)/2);
        return new int[] {R,(int)(RPlusM-M)};
    }
}
