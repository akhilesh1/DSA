class Solution {
    public int search(int[] nums, int target) {
        int N=nums.length;
        int start=0,end=N-1;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(nums[mid]==target)
            {
                return mid;
            }
            else if(nums[0]>nums[mid])//sorted range in right
            {
                if(nums[mid]<target && nums[N-1]>=target)//if our item in that range
                    start=mid+1;
                else
                    end=mid-1;
            }
            else//sorted range in left
            {
                if(nums[mid]>target && nums[0]<=target)//if our item in that range
                    end=mid-1; 
                else
                    start=mid+1;
            }
        }
        return -1;
    }
   
}