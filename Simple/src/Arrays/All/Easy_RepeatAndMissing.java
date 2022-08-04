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
        long XMinusY=currentSum-idealSum;
        long XSqMinusYSq=currentSumSquare-idealSumSquare;
        long XPlusY=(long)(XSqMinusYSq/XMinusY);
        int X=(int)((XMinusY+XPlusY)/2);
        return new int[] {X,(int)(XPlusY-X)};
    }
}
