public class Solution {
    public IList<int> FindSmallestSetOfVertices(int n, IList<IList<int>> edges) {
        var inDegree=new int[n];
        foreach(List<int> e in edges)
        {
            inDegree[e[1]]++;
        }
        var ans=new List<int>();
        for(int i=0;i<n;i++)//1254 30
        {
            if(inDegree[i]==0) ans.Add(i);
        }
        return ans;
    }
}