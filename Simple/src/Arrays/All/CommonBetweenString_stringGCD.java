
/*For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated with itself one or more times).

Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.

 

Example 1:

Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"
Example 2:

Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"*/

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        //if common devisor string exists then only we wiil calculate it otherwise return empty string;

        if((str1+str2).equals(str2+str1))//definately there exists a common devisor
        {
            //now common devisor must be as same length as the gcd of their length
            int gcdLength=getGCD(str1.length(),str2.length());
            return str1.substring(0,gcdLength);
        }
        else
            return "";

    }
    int getGCD(int b,int a)
    {
        if(a==0)
            return b;
        else
            return getGCD(a,b%a);
    }
}
