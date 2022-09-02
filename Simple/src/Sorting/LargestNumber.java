/*
Problem Description
Given an array A of non-negative integers, arrange them such that they form the largest number.

Note: The result may be very large, so you need to return a string instead of an integer.



Problem Constraints
1 <= len(A) <= 100000
0 <= A[i] <= 2*109

Solution approach
Just custom comparator
make X+Y and Y+X as string concatenation and check which is max
 */
package Sorting;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {
    public String largestNumber(final List<Integer> A) {
        StringBuilder sb=new StringBuilder();
        int N=A.size();
        Collections.sort(A,new Comparator<Integer>()
        {
            public int compare(Integer X, Integer Y){
                String XY = ""+X + Y;
                String YX = ""+Y + X;
                return XY.compareTo(YX);
            }
        });
        for(int i=N-1;i>=0;i--){
            sb.append(A.get(i));
        }
        if(A.get(N-1)==0)
            return "0";
        return sb.toString();

    }
}
