public class Solution {
    public string ReverseWords(string s) {
        s = s.Trim();
        var sb = new StringBuilder(s);

        int N = sb.Length;
        int l = 0;
        for (int i = 0; i < N; i++) {
            if (sb[i] == ' ' || i == N - 1) {
                int r = (i == N - 1) ? i : i - 1;
                ReverseString(l, r, sb);
                l = i + 1;
            }
        }

        return sb.ToString();
    }

    private void ReverseString(int l, int r, StringBuilder sb) {
        while (l < r) {
            char temp = sb[l];
            sb[l] = sb[r];
            sb[r] = temp;
            l++;
            r--;
        }
    }
}
