/*
#Lucky Numbers#

Problem Description
A lucky number is a number that has exactly 2 distinct prime divisors.

You are given a number A, and you need to determine the count of lucky numbers between the range 1 to A (both inclusive).

Problem Constraints
1 <= A <= 50000
 */
package Arrays.All;

public class Hard_2DistinctPrimeDivisor {
    public int solve(int A) {
        int[] S=new int[A+1];
        for(int i=2;i<=A;i++){
            if(S[i]==0){
                for(int j=i;j<=A;j+=i){
                    S[j]+=1;
                }
            }
        }
        int ans=0;
        for(int i=2;i<=A;i++){
            if(S[i]==2)
            {
                ans++;
            }
            //System.out.print(S[i]);
        }
        //System.out.println();
        return ans;
    }
}
