/*

You are given an integer array bloomDay, an integer m and an integer k.

You want to make m bouquets. To make a bouquet, you need to use k adjacent flowers from the garden.

The garden consists of n flowers, the ith flower will bloom in the bloomDay[i] and then can be used in exactly one bouquet.

Return the minimum number of days you need to wait to be able to make m bouquets from the garden. If it is impossible to make m bouquets return -1.

 

Example 1:

Input: bloomDay = [1,10,3,10,2], m = 3, k = 1
Output: 3

Input: bloomDay = [1,10,3,10,2], m = 3, k = 2
Output: -1
Explanation: We need 3 bouquets each has 2 flowers,
Input: bloomDay = [7,7,7,7,12,7,7], m = 2, k = 3
Output: 12
Explanation: We need 2 bouquets each should have 3 flowers
After day 7: [x, x, x, x, _, x, x]
We can make one bouquet of the first three flowers that bloomed. 
*/
class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(m*k>bloomDay.length)
            return -1;
        int end=0;
        int start=1;
        for(int i=0;i<bloomDay.length;i++)
        {
            end=Math.max(end,bloomDay[i]);
            start=Math.min(start,bloomDay[i]);
        }

        while(start<=end)
        {
            int days=start+(end-start)/2;
            int b1=getBouquetsCount(bloomDay,k,days);
            int b2=getBouquetsCount(bloomDay,k,days-1);
            if(b1>=m && b2<m)
                return days;
            else if(b1<m)
                start=days+1;
            else
                end=days-1;
        }
        return -1;
    }
    public int getBouquetsCount(int[] bloomDay,int flowers,int days)
    {
        int ans=0;
        int N=bloomDay.length;
        int flowerCount=0;
        for(int i=0;i<N;i++)
        {
            if(days>=bloomDay[i])
                flowerCount++;
            else
                flowerCount=0;

            if(flowerCount==flowers)//got 
            {
                ans++;
                flowerCount=0;
            }
        }
        return ans;
    }
}
