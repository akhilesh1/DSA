/*
Bottle in Bottle

Problem Description
Given an array of integers, A of length N denotes N cylindrical empty bottles. The radius of the ith bottle is A[i].
You can put the ith bottle into the jth bottle if the following conditions are met:

The ith bottle is not put into another bottle.
The jth bottle doesn't contain any other bottle.
The radius of bottle i is smaller than bottle j (A[i] < A[j]).
You can put bottles into each other any number of times. You want to MINIMIZE the number of visible bottles. A bottle is visible if it is not put into any other bottle.

Find and return the minimum number of visible bottles.



Problem Constraints
1 <= N <= 100000

1<= A[i] <= 100000000
Soltution approcah
1)using two pointer approach i and j
increse index i only when we get next j j>i
answer will be N-i as remaing elments were not get occupied
2)simply count max frequencey of min size bottle
eg frequency of min elment 2 here is 3 so ans will be three can be done using freq map
1 2 2 2 4 4 5 7
 */
package Sorting;
import java.util.Arrays;
public class GameOfBottle {
    public int solve(int[] A) {
        int N=A.length;
        Arrays.sort(A);
        int i=0;
        for(int j=1;j<N;j++){
            if(A[j]>A[i])
                i++;
        }
        return N-i;
    }
}
