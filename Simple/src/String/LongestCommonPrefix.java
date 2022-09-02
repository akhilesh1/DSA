/*
Problem Description
Given the array of strings A, you need to find the longest string S, which is the prefix of ALL the strings in the array.

The longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.

Example: the longest common prefix of "abcdefgh" and "abcefgh" is "abc".



Problem Constraints
0 <= sum of length of all strings <= 1000000

Solution approach
to match each char in string at a position
 */
package String;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] A) {
        int N=A.length;
        int index=0;
        int minLength=Integer.MAX_VALUE;
        String ans="";
        for(int i=0;i<N;i++){
            minLength=Math.min(minLength,A[i].length());
        }
        for(int j=0;j<minLength;j++){
            char c=A[0].charAt(j);
            for(int i=1;i<N;i++){
                if(A[i].charAt(j)!=c)
                    return ans;
            }
            ans+=c;
        }
        return ans;
    }
}
