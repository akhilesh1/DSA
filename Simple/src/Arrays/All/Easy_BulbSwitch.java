/*
Problem Description
A wire connects N light bulbs.

Each bulb has a switch associated with it; however, due to faulty wiring, a switch also changes the state of all the bulbs to the right of the current bulb.

Given an initial state of all bulbs, find the minimum number of switches you have to press to turn on all the bulbs.

You can press the same switch multiple times.

Note: 0 represents the bulb is off and 1 represents the bulb is on.

Example Input

Input 1:

 A = [0, 1, 0, 1]

Input 2:

 A = [1, 1, 1, 1]



Example Output

Output 1:

 4

Output 2:

 0

Problem Constraints
0 <= N <= 5×105
0 <= A[i] <= 1

Solution approach
carry forward concept
find effective state=cur state(toggle if odd number of requests)
we will increase count of switch only when its effective state is OFF


 */
package Arrays.All;

import java.util.ArrayList;

public class Easy_BulbSwitch {
    public int bulbs(ArrayList<Integer> A) {
        int N=A.size();
        int count=0;
        for(int i=0;i<N;i++){

            boolean needSwitch=A.get(i)==0;
            if(count%2==1)//got odd switch
                needSwitch=!needSwitch;
            if(needSwitch)
            {
                count++;
            }
        }
        return count;
    }
   //More consice version
   // only need to count that when we need a toggle
  // toggle if current state + previous toggle is zero
   public int bulbs(int[] A) {
        int ans=0;
        for(int i=0;i<A.length;i++){
            if((A[i]==0 && ans%2==0)||(A[i]==1 && ans%2==1))
                ans++;
        }
        return ans;
    }
}
