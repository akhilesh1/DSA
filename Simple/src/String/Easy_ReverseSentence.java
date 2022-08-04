/*
Problem Description
You are given a string A of size N.

Return the string A after reversing the string word by word.

NOTE:

A sequence of non-space characters constitutes a word.
Your reversed string should not contain leading or trailing spaces, even if it is present in the input string.
If there are multiple spaces between words, reduce them to a single space in the reversed string.


Problem Constraints
1 <= N <= 3 * 105

Solution
full reverse sentence then reverse each word mark ending index by space or end of sentence
 */
package String;

public class Easy_ReverseSentence {
    public String solve(String A) {
        A=A.trim();
        int N=A.length();
        StringBuilder sb=new StringBuilder(A.trim());
        //full reverse
        sb=reverseString(0,N-1,sb);
        //trverse and reverse word
        int l=0,r=-1;
        for(int i=0;i<N;i++){
            if(sb.charAt(i)==' '|| i==N-1)
            {
                r=i==N-1?i:i-1;
                sb=reverseString(l,r,sb);
                l=i+1;
            }
        }
        return sb.toString();
    }

    public StringBuilder reverseString(int l,int r,StringBuilder sb){
        while(l<r){
            char temp=sb.charAt(l);
            sb.setCharAt(l,sb.charAt(r));
            sb.setCharAt(r,temp);
            l++;
            r--;
        }
        return sb;
    }
}
