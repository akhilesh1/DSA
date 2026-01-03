public class Solution {
    public bool ValidPath(int n, int[][] edges, int source, int destination) {
        //prepare adj list

        if(source==destination) return true;
         var adj=new Dictionary<int,List<int>>();
         foreach(int[] arr in edges)
         {
            if(!adj.ContainsKey(arr[0]))
                adj[arr[0]]=new List<int>();
            
            adj[arr[0]].Add(arr[1]);

            if(!adj.ContainsKey(arr[1]))
                adj[arr[1]]=new List<int>();
            
            adj[arr[1]].Add(arr[0]);
         }
        //Do DFS
        Queue<int> queue=new();
        queue.Enqueue(source);

        HashSet<int> visited=new();
        visited.Add(source);
        while(queue.Count!=0)
        {
            var cur=queue.Dequeue();
            if(adj.ContainsKey(cur))
            {
                foreach(int item in adj[cur])
                {
                    if(item==destination) return true;
                    if(!visited.Contains(item))
                    {
                        queue.Enqueue(item);
                        visited.Add(item);
                    }
                }
            }
        }
        return false;
    }
}