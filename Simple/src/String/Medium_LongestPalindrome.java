/*
Problem Description
Given a string A of size N, find and return the longest palindromic substring in A.

Substring of string A is A[i...j] where 0 <= i <= j < len(A)

Palindrome string:
A string which reads the same backwards. More formally, A is palindrome if reverse(A) = A.

Incase of conflict, return the substring which occurs first ( with the least starting index).



Problem Constraints
1 <= N <= 6000

Solution approach
fix the center and check for every index as center
if center is single char
if center is two chars adjecent char
 */
package String;

public class Medium_LongestPalindrome {
    public String longestPalindrome(String A) {

        int N=A.length();
        if(N==1)
            return A;
        int maxLength=0;
        int ansStart=-1,ansEnd=-1;
        for(int i=0;i<N-1;i++){
            int[] A1=getMaxLengthIndexes(A,i,i+1);
            if((A1[1]-A1[0]+1)>maxLength){
                maxLength=A1[1]-A1[0]+1;
                ansStart=A1[0];
                ansEnd=A1[1];
            }
            int[] A2=getMaxLengthIndexes(A,i,i);
            if((A2[1]-A2[0]+1)>maxLength){
                maxLength=A2[1]-A2[0]+1;
                ansStart=A2[0];
                ansEnd=A2[1];
            }

        }
        return A.substring(ansStart,ansEnd+1);
    }
    int[] getMaxLengthIndexes(String A,int l,int r){
        int[] arr=new int[2];
        int N=A.length();
        int maxLength=0;
        while(l>=0 && r<N && A.charAt(l)==A.charAt(r)){
            l--;
            r++;
        }
        arr[0]=l+1;
        arr[1]=r-1;
        return arr;
    }
}
