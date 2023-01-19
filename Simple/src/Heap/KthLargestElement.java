/*
Problem Description
Given an integer array B of size N.

You need to find the Ath largest element in the subarray [1 to i], where i varies from 1 to N. In other words, find the Ath largest element in the sub-arrays [1 : 1], [1 : 2], [1 : 3], ...., [1 : N].

NOTE: If any subarray [1 : i] has less than A elements, then the output should be -1 at the ith index.



Problem Constraints
1 <= N <= 100000
1 <= A <= N
1 <= B[i] <= INT_MAX

Solution approach
define bucket of K element
Kth largest will be min heap of that bucket

 */

package Heap;

import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 5, 6};
        var result = getKthLargestElement(input, 4);
        System.out.println("Result:");
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }

    static int[] getKthLargestElement(int[] B, int A) {
        int N = B.length;
        int[] ans = new int[N];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < A; i++) {
            pq.add(B[i]);
            if(i<A-1)
                ans[i] = -1;
        }
        ans[A-1]=pq.peek();
        for (int i = A; i < N; i++) {
            if (B[i] > pq.peek()) {
                pq.remove();
                pq.add(B[i]);
            }
            ans[i] = pq.peek();
        }
        return ans;
    }
}
