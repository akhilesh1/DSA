public class Solution {
    public int Trap(int[] height) {
        //4,2,9,3,2,5
        //0,4,4,9
        int ans=0;
        int N=height.Length;
        if(N==1)
            return 0;
        int[] maxLeft=new int[N];
        maxLeft[0]=height[0];
        for(int i=1;i<N;i++)
        {
            maxLeft[i]=Math.Max(maxLeft[i-1],height[i]);
        }
        int maxRight=0;
        for(int i=N-2;i>=0;i--)
        {
            maxRight=Math.Max(maxRight,height[i+1]);
            int curr=Math.Min(maxLeft[i],maxRight)-height[i];
            if(curr>0)
                ans+=curr;
        }
        return ans;
    }
}