public class Solution {
    public int[] ProductExceptSelf(int[] nums) {
       
        //2  ,6 ,24,120
        //2  ,3 ,4 ,5
        //120,60,20,5
        int N=nums.Length;
        int[] prefixMultiplication= new int[N];
        prefixMultiplication[0]=nums[0];

        int[] postfixMultiplication= new int[N];
        postfixMultiplication[N-1]=nums[N-1];
        for(int i=1;i<N;i++)
        {
            prefixMultiplication[i]=prefixMultiplication[i-1]*nums[i];
        }
        for(int i=N-2;i>=0;i--)
        {
            postfixMultiplication[i]=postfixMultiplication[i+1]*nums[i];
        }
        int[] ans=new int[N];
        for(int i=0;i<N;i++)
        {
            int left=1;
            int right=1;
            if(i>0)
                left=prefixMultiplication[i-1];
            if(i<N-1)
                right=postfixMultiplication[i+1];
            
            ans[i]=left*right;

        }

        return ans;
    }
}