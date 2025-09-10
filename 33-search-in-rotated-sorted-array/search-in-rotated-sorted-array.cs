public class Solution {
    public int Search(int[] nums, int target) {
        int N=nums.Length;
        int left=0;
        int right=N-1;
        while(left<=right)
        {
            int mid=(left+right)/2;
            if(target==nums[mid])  return mid;
            else if(nums[0]<=nums[mid])//if left portion is sorted ascending
            {
                if(target<nums[mid] && target>=nums[0])//make sure target in that sorted space only
                    right=mid-1;
                else
                    left=mid+1;
            }
            else//right portion is sorted ascending
            {
                if(target>nums[mid] && target<=nums[N-1])//make sure target in that sorted space only
                    left=mid+1;
                else
                    right=mid-1;
            }
        }
        return -1;
    }
}