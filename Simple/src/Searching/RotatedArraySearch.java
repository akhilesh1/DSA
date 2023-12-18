
//First find the sorted portion.

//First priority is given to the sorted range, we prefer to go to that range, but

//If sorted porttion range is not ok then go for not sorted discrete space.

package Searching;

public class RotatedArraySearch {
    public int search(final int[] A, int B) {
        int N = A.length;
        int L = 0, R = N - 1;
        int ans = -1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (A[mid] == B) {
                ans = mid;
                break;
            }
            else if (A[mid] >= A[0])//left portion is sorted
            {
                if (B >= A[0] && B < A[mid])//target lies in sorted section
                    R = mid - 1;//go left
                else//target does not lies in sorted section
                    L = mid + 1;//go right
            }
            else
            {// right section sorted
                if (B > A[mid] && B <= A[N - 1])//target in larger set
                    L = mid + 1;//go right
                else// mid and target both in smaller set
                    R = mid - 1;
            }
        }
        return ans;
    }
}
