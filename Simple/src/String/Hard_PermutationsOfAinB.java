/*
Problem Description
You are given two strings, A and B, of size N and M, respectively.

You have to find the count of all permutations of A present in B as a substring. You can assume a string will have only lowercase letters.



Problem Constraints
1 <= N < M <= 105

Solution Approach

Idea : if  A string has a valid permutation in *B* then then freq map of current and target should be same

Find frequency map of search string A
find frequency map of first substring
slide and update frequency (add new char's freq) remove old char frequency
count freq
 */
package String;

public class Hard_PermutationsOfAinB {
    public int solve(String A, String B) {
        int ans=0;
        int N=A.length();
        int M=B.length();
        if(N>M)
            return 0;
        int[] f1=new int[26];
        int[] f2=new int[26];
        for(int i=0;i<N;i++){
            f1[A.charAt(i)-'a']++;
        }

        for(int i=0;i<N;i++){
            f2[B.charAt(i)-'a']++;
        }
        ans+=isCountEqual(f1,f2);
        //other windows
        for(int i=N,j=0;i<M;i++,j++){
            f2[B.charAt(i)-'a']++;
            f2[B.charAt(j)-'a']--;
            ans+=isCountEqual(f1,f2);
        }
        return ans;

    }
    int isCountEqual(int[] f1,int[] f2)
    {
        for(int i=0;i<26;i++)
        {
            if(f1[i]!=f2[i])
                return 0;
        }
        return 1;
    }
}
