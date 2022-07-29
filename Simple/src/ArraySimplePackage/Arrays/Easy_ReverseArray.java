/*
Problem Description
You are given a constant array A.

You are required to return another array which is the reversed form of the input array.

 */
package ArraySimplePackage.Arrays;

public class Easy_ReverseArray {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] solve(final int[] A) {
        int[] result= new int[A.length];
        result=A;
        int startIndex=0;
        int endIndex=A.length-1;
        while(startIndex<endIndex){
            int a=result[startIndex];
            int b=result[endIndex];
            a=b-a;
            b=b-a;
            a=a+b;
            result[startIndex]=a;
            result[endIndex]=b;
            startIndex++;
            endIndex--;
        }
        return result;
    }
}

