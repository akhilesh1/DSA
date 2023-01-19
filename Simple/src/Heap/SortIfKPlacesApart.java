package Heap;

import java.util.PriorityQueue;

public class SortIfKPlacesApart {
    public static void main(String[] args) {
        int[] input = {2, 1, 17, 10, 21, 95};
        int[] result = solve(input, 1);
        System.out.print("K distance apart sort output:");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + ", ");
        }
    }

    public static int[] solve(int[] A, int B) {
        int[] ans=new int[A.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < B; i++) {
            pq.add(A[i]);
        }
        int idx=0;
        for (int i = B; i < A.length; i++) {
            ans[idx++] = pq.poll();
            pq.add(A[i]);
        }
        while(!pq.isEmpty())
        {
            ans[idx++]=pq.poll();
        }
        return ans;
    }
}
