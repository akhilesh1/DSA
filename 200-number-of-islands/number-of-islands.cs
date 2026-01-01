public class Solution
{
    public int NumIslands(char[][] grid)
    {
        int N = grid.Length;
        int M = grid[0].Length;

        int[][] visited = new int[N][];
        for (int i = 0; i < N; i++)
            visited[i] = new int[M];

        int ans = 0;

        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < M; j++)
            {
                if (visited[i][j] == 0 && grid[i][j] == '1')
                {
                    DFS(i, j, grid, visited);
                    ans++;
                }
            }
        }
        return ans;
    }

    public void DFS(int i, int j, char[][] grid, int[][] visited)
    {
        int N = grid.Length;
        int M = grid[0].Length;

        // boundary FIRST
        if (i < 0 || j < 0 || i >= N || j >= M)
            return;

        if (visited[i][j] == 1 || grid[i][j] == '0')
            return;

        visited[i][j] = 1;

        int[][] directions = new int[][]
        {
            new int[] { 0, 1 },
            new int[] { 1, 0 },
            new int[] { 0, -1 },
            new int[] { -1, 0 }
        };

        foreach (int[] d in directions)
        {
            DFS(i + d[0], j + d[1], grid, visited);
        }
    }
}
