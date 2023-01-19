/*
Problem Description
Given an array of integers, A denoting a stream of integers. New arrays of integer B and C are formed.
Each time an integer is encountered in a stream, append it at the end of B and append the median of array B at the C.

Find and return the array C.

NOTE:

If the number of elements is N in B and N is odd, then consider the median as B[N/2] ( B must be in sorted order).
If the number of elements is N in B and N is even, then consider the median as B[N/2-1]. ( B must be in sorted order).


Problem Constraints
1 <= length of the array <= 100000
1 <= A[i] <= 109
 */
package Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class RunningMedian {
    public static void main(String[] args) {
        int[] input = {1, 2, 5, 4, 3};
        int[] result = solve(input);
        System.out.print("Running stream output:");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ", ");
        }

    }

    static public int[] solve(int[] A) {
        int N = A.length;
        int[] ans = new int[N];
        //create min heap and max heap
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(N, Collections.reverseOrder());
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();
        //iterate
        //int leftCount = 0;
        //int rightCount = 0;
        pqMax.add(A[0]);
        ans[0] = A[0];
        for (int i = 1; i < N; i++) {
            //  add
            if (A[i] < pqMax.peek()) {
                pqMax.add(A[i]);
                //leftCount++;
            } else {
                pqMin.add(A[i]);
//                rightCount++;
            }
            //  balance
            if (pqMax.size() < pqMin.size()) {
                pqMax.add(pqMin.remove());
                //leftCount++;
            } else if (pqMax.size() - pqMin.size() > 1) {
                pqMin.add(pqMax.remove());
                //rightCount++;
            }
            //  addToResult
            //if (i % 2 == 0)//==>index even items ODD
                ans[i] = pqMax.peek();
            //else
            //    ans[i] = (pqMin.peek() + pqMax.peek()) / 2;
        }
        return ans;
    }
}
