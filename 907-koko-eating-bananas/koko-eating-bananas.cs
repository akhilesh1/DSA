public class Solution {
    public int MinEatingSpeed(int[] piles, int h) {
        //approach iterate 
        //take avg
        //now increase or decrease and check if how  it crosses h or below h
        //3 +11=14 /2 ==7  
        //check 7 h required 5
        //so decrease to 6
        //check 6 h required 6
        //check 5 h required 1+2+2+3=8
        //check 4 h req=1+2+2+3=8
        //check 3 h 1+2+3+3
        //can we sort : no
        int min=1;
        int max=int.MinValue;
        int N=piles.Length;
        for(int i=0;i<N;i++)
        {
            max=Math.Max(max,piles[i]);
        }

        while(min<=max)
        {
            int mid=min+(max-min)/2;

            //if(GetHoursTaken(piles,mid)==h && GetHoursTaken(piles,mid-1)>h)
            //    return mid;
            if(GetHoursTaken(piles,mid)>h)//aur khao
                min=mid+1;
            else
                max=mid-1;


        }
        return min;
    }
    public long GetHoursTaken(int[] piles, int k)
    {
        int N=piles.Length;
        long result=0;
        for(int i=0;i<N;i++)
        {
            result+=(long)Math.Ceiling((double)piles[i] / k);
        }
        return result;
    }


}