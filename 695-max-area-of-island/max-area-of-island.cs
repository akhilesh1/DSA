public class Solution {
    public int MaxAreaOfIsland(int[][] grid) {
        //have visited matrix
        int maxArea=0;
        int N=grid.Length;
        int M=grid[0].Length;
        var visited=new bool[N][];
        for (int i = 0; i < N; i++)
        {
            visited[i] = new bool[M]; // Initialize the inner array with M columns (or any other size)
        }
        //get checked what is not visited and 1
        for(int i=0;i<N;i++)
        for(int j=0;j<M;j++)
        {
            var area=0;
            if(grid[i][j]==1 && visited[i][j]==false)
                DFS(i,j,grid,visited,ref area);
            
            maxArea=Math.Max(maxArea,area);
        }
            //do DFS
            //count 1's
            //when end replace max
        return maxArea;
    }

    public void DFS(int i,int j,int[][] grid,bool[][] visited,ref int area)
    {
        int N=grid.Length;
        int M=grid[0].Length;

        if(i<0 || i>N-1 || j<0 || j>M-1) return;

        if(grid[i][j]==0 || visited[i][j]==true) return;



        visited[i][j]=true;
        area+=1;
        DFS(i+1,j,grid,visited,ref area);
        DFS(i-1,j,grid,visited,ref area);
        DFS(i,j+1,grid,visited,ref area);
        DFS(i,j-1,grid,visited,ref area);
        
    }
}