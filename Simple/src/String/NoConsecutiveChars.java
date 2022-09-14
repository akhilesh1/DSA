/*
Problem Description
You are given a string A of lowercase English alphabets. Rearrange the characters of the given string A such that there is no boring substring in A.

A boring substring has the following properties:

Its length is 2.
Both the characters are consecutive, for example - "ab", "cd", "dc", "zy" etc.(If the first character is C then the next character can be either (C+1) or (C-1)).
Return 1 if it is possible to rearrange the letters of A such that there are no boring substrings in A else, return 0.

Solution Approach
we only need to avoid consecutive chars , repeat char can occur

we can take help ascii values to separate two group of odd even chars
and check if the groups are making a valid string
 */

package String;
import java.util.Arrays;
public class NoConsecutiveChars {
    public int solve(String A) {
        int N=A.length();
        StringBuilder evenChars=new StringBuilder();
        StringBuilder oddChars=new StringBuilder();;
        for(int i=0;i<N;i++)
        {
            if(A.charAt(i)%2==0)
                evenChars.append(A.charAt(i));
            else
                oddChars.append(A.charAt(i));
        }
        char[] evenArr=evenChars.toString().toCharArray();//new char[evenChars.length]
        char[] oddArr=oddChars.toString().toCharArray();
        Arrays.sort(evenArr);
        Arrays.sort(oddArr);
        //System.out.println("E:"+new String(evenArr));
        //System.out.println("O:"+new String(oddArr));
        if(Math.abs(evenArr[evenArr.length-1]-oddArr[0])!=1)
            return 1;
            //oddChars+evenChars
        else if(Math.abs(oddArr[oddArr.length-1]-evenArr[0])!=1)
            return 1;
        else
            return 0;


    }
}
