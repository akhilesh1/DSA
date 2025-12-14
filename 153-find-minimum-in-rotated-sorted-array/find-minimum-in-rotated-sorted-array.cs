public class Solution {
    public int FindMin(int[] nums) {
        //4,5,6,7,0,1,2
        //find the delflection point by binary search
        //how would you find that?
        //one less left one less right
        int N=nums.Length;
        int left=0;
        int right=N-1;
        int ans=int.MaxValue;
        //If already sorted 
        

        while(left<=right)
        {
            if(nums[left]<nums[right]) 
            {
                ans = Math.Min(ans, nums[left]);
                break;
            }
            int mid=(left+right)/2;
            ans=Math.Min(nums[mid],ans);
            if(nums[left]<=nums[mid])//left is sorted
            {
                left=mid+1;
            }
            else//right is sorted
            {
                right=mid-1;
            }
            
        }
        return ans;
    }
}