/*
Problem Description
Given an even number A ( greater than 2 ), return two prime numbers whose sum will be equal to the given number.

If there is more than one solution possible, return the lexicographically smaller solution.

If [a, b] is one solution with a <= b, and [c,d] is another solution with c <= d, then
[a, b] < [c, d], If a < c OR a==c AND b < d.

Problem Constraints
4 <= A <= 2*107

Solution
we simply need to iterate and check for every if i and A-i are prime
Since above task of checking prime we need to do repeatedly
Lets make a Sieve array for this.
 */
package Arrays.All;

public class Hard_PrimeSum {
    public int[] primesum(int A) {
        int[] S= new int[A+1];
        for(int i=2;i*i<=A;i++){
            if(S[i]==0){
                for(int j=i*i;j<=A;j+=i){
                    S[j]=1;
                    //System.out.print(j);
                }
            }

        }
        //System.out.println();
        int[] ans=new int[2];
        for(int i=2;i<=A;i++){
            if((S[i]!=1 && S[A-i]!=1) ){
                ans[0]=i;
                ans[1]=A-i;
                break;
            }

        }
        return ans;
    }
}
