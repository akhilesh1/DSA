public class Solution {
    public int Search(int[] nums, int target) {
        int N=nums.Length;
        int left=0;
        int right=N-1;
        //if (N==1 && target==nums[0]) return 0;
        while(left<=right)
        {            
            int mid=(left+right)/2;

            if(nums[mid]==target) return mid;
            else if(nums[mid]<target)
            {
                left=mid+1;
            }
            else
                right=mid-1;
        }
        return -1;

    }
}