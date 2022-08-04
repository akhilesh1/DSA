
/*
(Q)## N/3 Repeat Number ##
Problem Description
You're given a read-only array of N integers. Find out if any integer occurs more than N/3 times in the array in linear time and constant additional space.
If so, return the integer. If not, return -1.

If there are multiple solutions, return any one.



Problem Constraints
1 <= N <= 7*105
1 <= A[i] <= 109
solution approach
item1,item2 and freq1,freq2

get item1 and item2 check if anyone of it have really freqency >N/3

 */
package Arrays.All;

import java.util.List;

public class Medium_MajorityElement_N3 {
    public int repeatedNumber(final List<Integer> a) {
        //return 0;
        int currentItem=-1;
        int frequency=0;
        int currentItem2=-1;
        int frequency2=0;
        for(int i=0;i<a.size();i++){
            if(currentItem==a.get(i)){
                frequency++;
            }
            else if(currentItem2==a.get(i)){
                frequency2++;
            }
            else if(frequency==0){
                currentItem=a.get(i);
                frequency=1;
            }
            else if(frequency2==0){
                currentItem2=a.get(i);
                frequency2=1;
            }
            else
            {
                frequency--;
                frequency2--;
            }


        }
        int f1=0,f2=0;
        for(int i=0;i<a.size();i++){
            if(a.get(i)==currentItem)
                f1++;
            else if(a.get(i)==currentItem2)
                f2++;
        }
        if(f1>a.size()/3)
            return currentItem;
        else if(f2>a.size()/3)
            return currentItem2;
        else
            return -1;
    }
}
