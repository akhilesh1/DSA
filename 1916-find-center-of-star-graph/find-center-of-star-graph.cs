public class Solution {
    public int FindCenter(int[][] edges) {
        var inDegree=new Dictionary<int,int>();
        int ans=-1;
        foreach(var e in edges)//1 1 , 2 2 ,3 1  
        {
            if(!inDegree.ContainsKey(e[0])) inDegree[e[0]]=0;
            inDegree[e[0]]++;          
            ans=Math.Max(ans,inDegree[e[0]]);

            if(!inDegree.ContainsKey(e[1])) inDegree[e[1]]=0;
            inDegree[e[1]]++;
            ans=Math.Max(ans,inDegree[e[1]]);
        }
        foreach(var e in inDegree)
        {
            if(e.Value==ans)
                return e.Key;
        }
        return ans;
    }
}