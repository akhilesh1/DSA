public class Solution {
    public IList<IList<string>> GroupAnagrams(string[] strs) {
        var lstStrings = new List<IList<string>>();
        int N = strs.Length;
        Dictionary<string, int> map = new();
        for (int i = 0; i < N; i++) {
            var key = GetSortedString(strs[i]);
            if (map.ContainsKey(key)) {
                lstStrings[map[key]].Add(strs[i]);
            } else {
                lstStrings.Add(new List<string>() { strs[i] });
                map[key] = lstStrings.Count - 1;
            }
        }
        return lstStrings;
    }

    string GetSortedString(string str) {
        var arr = str.ToCharArray();
        Array.Sort(arr);
        return new string(arr);
    }
}
