/*
Problem Description
Given an array of size N, find the majority element. The majority element is the element that appears more than floor(n/2) times.
You may assume that the array is non-empty and the majority element always exists in the array.

Example Input
Input 1:
[2, 1, 2]
Input 2:
[1, 1, 1]


Example Output
Input 1:
2
Input 2:
1


Problem Constraints
1 <= N <= 5*105
1 <= num[i] <= 109

Solution approach |==>
Freq=1 curItem=A[0]
increse the freq if same element found
decrease the frequency if same as previous element not found
if (freq==0) set curItem=A[i] and freq=1

 */
package Arrays.All;

public class Easy_MajorityElement {
    public int majorityElement(final int[] A) {
        int currentItem=A[0];
        int frequency=1;
        for(int i=1;i<A.length;i++){
            if(A[i]!=currentItem){
                frequency--;
                if(frequency==0)
                {
                    currentItem=A[i];
                    frequency=1;
                }

            }
            else
                frequency++;

        }
        return currentItem;
    }
}
