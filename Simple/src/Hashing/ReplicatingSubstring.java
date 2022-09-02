/*
Problem Description

Given a string B, find if it is possible to re-order the characters of the string B so that it can be represented as a concatenation of A similar strings.

Eg: B = aabb and A = 2, then it is possible to re-arrange the string as "abab" which is a concatenation of 2 similar strings "ab".

If it is possible, return 1, else return -1.



Problem Constraints
1 <= Length of string B <= 1000
1 <= A <= 1000

All the alphabets of S are lower case (a - z)

Solution approach
if we are rearranging chars we must have proper number of chars available
just create a frequency map and if frequency of each char is mulple of A then we can form the string
 */
package Hashing;

import java.util.HashMap;

public class ReplicatingSubstring {
    public int solve(int A, String B) {
        int N=B.length();
        if((N%A)!=0)
            return -1;
        HashMap<Character,Integer> hm=new HashMap<Character,Integer>();
        for(int i=0;i<N;i++)
        {
            Character c=B.charAt(i);
            if(hm.containsKey(c))
                hm.put(c,hm.get(c)+1);
            else
                hm.put(c,1);
        }
        //System.out.println("Values Length : "+hm.values());
        for(int val:hm.values())
        {
            if((val%A)!=0)
                return -1;
        }
        return 1;
    }
}
