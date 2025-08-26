public class Solution {
    public bool IsPalindrome(string s) {
        char[] arr=s.ToCharArray();
        int N=arr.Length;
        int left=0;
        int right=N-1;

        while(left<right)
        {
            
            if(!Char.IsLetterOrDigit(arr[left]))
            {
                left++;
                continue;
            }
            if(!Char.IsLetterOrDigit(arr[right]))
            {
                right--;
                continue;
            }

            if(Char.ToLower(arr[left])!=Char.ToLower(arr[right])) return false;

            left++;
            right--;
        }
        return true;
    }
}