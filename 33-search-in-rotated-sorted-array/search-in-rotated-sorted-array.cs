public class Solution {
    public int Search(int[] nums, int target) {
        //7012456
        //2456701
        int start=0;
        int end=nums.Length-1;
        while(start<=end)
        {
            int mid=(start+end)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]>=nums[start])//left sorted
            {
                if(target>=nums[start] && target<nums[mid])//if will u find it in left
                    end=mid-1;
                else
                    start=mid+1;
            }
            else//right sorted
            {
                if(target>nums[mid] && target<=nums[end])
                    start=mid+1;
                else
                    end=mid-1;
            }

        }
        return -1;
    }
}