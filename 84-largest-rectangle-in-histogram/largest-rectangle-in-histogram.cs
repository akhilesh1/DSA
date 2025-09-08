public class Solution {
    public int LargestRectangleArea(int[] heights) {
        int n = heights.Length;
        if (n == 0) return 0;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<int> st = new Stack<int>();

        for (int i = 0; i < n; i++) {
            while (st.Count > 0 && heights[st.Peek()] >= heights[i]) st.Pop();
            left[i] = st.Count == 0 ? -1 : st.Peek();
            st.Push(i);
        }

        st.Clear();
        for (int i = n - 1; i >= 0; i--) {
            while (st.Count > 0 && heights[st.Peek()] >= heights[i]) st.Pop();
            right[i] = st.Count == 0 ? n : st.Peek();
            st.Push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            ans = Math.Max(ans, width * heights[i]);
        }
        return ans;
    }
}
