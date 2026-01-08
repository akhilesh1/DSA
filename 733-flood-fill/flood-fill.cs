public class Solution {
    public int[][] FloodFill(int[][] image, int sr, int sc, int color) {
        int startingColour=image[sr][sc];
        int[][] visited = new int[image.Length][];
        for (int i = 0; i < image.Length; i++)
        {
            visited[i] = new int[image[0].Length];
        } 
        DFS(image,sr,sc,color,startingColour,visited);
        return image;
    }
    void DFS(int[][] image,int sr,int sc,int colourToBe,int startingColour,int[][] visited)
    {
        if(sr==-1 || sc==-1 || sr == image.Length || sc == image[0].Length ) return;

        if(visited[sr][sc]==1) return;

        visited[sr][sc]=1;

        if(image[sr][sc]!=startingColour) return;
        image[sr][sc]=colourToBe;
        DFS(image,sr+1,sc,colourToBe,startingColour,visited);
        DFS(image,sr,sc+1,colourToBe,startingColour,visited);
        DFS(image,sr-1,sc,colourToBe,startingColour,visited);
        DFS(image,sr,sc-1,colourToBe,startingColour,visited);
    }
}