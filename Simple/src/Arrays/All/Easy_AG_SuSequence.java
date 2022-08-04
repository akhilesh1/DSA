/*
Problem Description
You have given a string A having Uppercase English letters.

You have to find how many times subsequence "AG" is there in the given string.

NOTE: Return the answer modulo 109 + 7 as the answer can be very large.



Problem Constraints
1 <= length(A) <= 105

Solution
we need to traverse from the right and carry forward the g count with starting a
 */
package Arrays.All;

public class Easy_AG_SuSequence {
    public int solve(String A) {
        int ss=0;
        int gOccurance=0;
        for(int i=A.length()-1;i>=0;i--){
            if(A.charAt(i)=='G')
                gOccurance++;
            else if(A.charAt(i)=='A'){
                ss+=gOccurance;
            }

        }
        return ss;
    }
}
