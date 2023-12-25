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
