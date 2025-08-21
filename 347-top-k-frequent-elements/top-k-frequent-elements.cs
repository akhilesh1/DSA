public class Solution {
    public int[] TopKFrequent(int[] nums, int k) {
        //1112234
        //1-3
        //2-2
        //3-1
        //4-1
        //
        //[1,[3,4]][2,2][3,1]
       Dictionary<int,int> map=new();
       int N=nums.Length;
       for(int i=0;i<N;i++)
       {
            if(map.ContainsKey(nums[i]))
                map[nums[i]]=map[nums[i]]+1;
            else
                map[nums[i]]=1;
       }
       List<int>[] buckets=new List<int>[N+1];
       for (int i = 0; i <= N; i++) {
            buckets[i] = new List<int>();
        }
       foreach(var kvp in map)
       {

            buckets[kvp.Value].Add(kvp.Key);
       }
       int[] ans=new int[k];
       int bucketLength=buckets.Length;
       int idx=0;
       for (int i = N; i >= 0 && idx < k; i--) {
            if (buckets[i].Count > 0) {
                foreach (var num in buckets[i]) {
                    if (idx == k)
                        break;
                    ans[idx++] = num;
                }
            }
        }
       return ans;

    }
}