public class Solution {
    public string LargestNumber(int[] nums) {
        //sort number by first digit then by second digit
        var strNums = nums.Select(n => n.ToString()).ToArray();

        Array.Sort(strNums, (a, b) => string.Compare(b + a, a + b, StringComparison.Ordinal));

       if (strNums[0] == "0") return "0";
        //
        return string.Concat(strNums);
    }
}