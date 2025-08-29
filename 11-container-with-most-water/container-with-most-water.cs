public class Solution {
    public int MaxArea(int[] height) {
        int N=height.Length;
        int left=0;
        int right=N-1;
        int ans=int.MinValue;
        //1,8,6,2,5,4,8,3,7
        //0 1 2 3 4 5 6 7 8
        //8-1 =7
        while(left<right)
        {
            int curWater=(right-left)*Math.Min(height[left],height[right]);
            ans=Math.Max(ans,curWater);
            if(height[left]<=height[right])
                left++;
            else
                right--;
        }
        return ans;
    }
}