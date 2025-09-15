public class Solution {
    public int LengthOfLongestSubstring(string s) {
    int N = s.Length;
    int left = 0, right = 0;
    int ans = 0;
    HashSet<char> set = new();

    while (right < N) {
        if (set.Contains(s[right])) {
            set.Remove(s[left]);
            left++;
        } 
        else {
            set.Add(s[right]);
            ans = Math.Max(ans, set.Count);
            right++;
        }
    }
    return ans;
}
}