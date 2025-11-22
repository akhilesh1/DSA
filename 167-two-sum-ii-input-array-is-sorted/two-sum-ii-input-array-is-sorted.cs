public class Solution {
    public int[] TwoSum(int[] numbers, int target) {
        int N=numbers.Length;
        int start=0;
        int end=N-1;
        while(start<end)
        {
            int curSum=numbers[start]+numbers[end];
            if(curSum==target)
                return [start+1,end+1];
            else if(curSum>target)
                end-=1;
            else
                start+=1;
        }
        return [0,0];
    }
}