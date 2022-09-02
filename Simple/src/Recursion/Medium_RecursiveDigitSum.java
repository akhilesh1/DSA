/*
Problem Description
Given a number A, check if it is a magic number or not.

A number is said to be a magic number if the sum of its digits is calculated till a single digit recursively by adding the sum of the digits after every addition. If the single digit comes out to be 1, then the number is a magic number.



Problem Constraints
1 <= A <= 109

Solution approach
First get sum of all digits
using while loop check if the sum of digit is single digit
 */
package Recursion;

public class Medium_RecursiveDigitSum {
    public int solve(int A) {
        while(A>=10)
            A=getSum(A);
        if(A==1)
            return 1;
        else
            return 0;
    }
    public int getSum(int A){
        //System.out.println(A);
        if(A<10)
            return A;
        int sum = A%10+getSum(A/10);//23

        return sum;
    }
}
