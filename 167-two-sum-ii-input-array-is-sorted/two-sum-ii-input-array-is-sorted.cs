public class Solution {
    public int[] TwoSum(int[] numbers, int target) {
        int N=numbers.Length;
        int left=0;
        int right=N-1;
        while(left<right)
        {
            int curSum=numbers[left]+numbers[right];
            
            if(curSum==target)  return new[] {left+1,right+1};

            if(curSum>target) right--;
            else left++;
        }
        return new[] {0,0};
    }
}