/*
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.

 

Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4

*/

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start=1;
        int end=-1;
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<piles.length;i++)
            end=Math.end(end,piles[i]);
        int midEatingSpeed=0;
        
        while(start<=end)
        {
            midEatingSpeed=start+(end-start)/2;
            boolean eatable=canEat(piles,midEatingSpeed,h);
            if(eatable && !canEat(piles,midEatingSpeed-1,h))
                return midEatingSpeed;
            if(!eatable) start=midEatingSpeed+1;
            else  end=midEatingSpeed-1;
        }
        return midEatingSpeed;
    }

    public boolean canEat(int[] piles,int midEatingSpeed,int h)
    {
        int eatingTime=0;
        for(int i=0;i<piles.length;i++)
        {
            int result=0;
            if(piles[i]<midEatingSpeed)
                result=1;
            else
                result=(int)Math.ceil((double)piles[i]/midEatingSpeed);
            
            eatingTime+=result;
        }
        return eatingTime<=h;
    }
}
