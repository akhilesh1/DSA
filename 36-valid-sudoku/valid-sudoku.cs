public class Solution {
    public bool IsValidSudoku(char[][] board) {
        if(!validBlocks(board)) return false;
        if(!validRowsCols(board)) return false;
        
        return true;
    }
    bool validBlocks(char[][] board)
    {
        for(int i=0;i<9;i+=3)
        {
            for(int j=0;j<9;j+=3)
            {
                HashSet<char> set=new();
                for(int k=i;k<i+3;k++)
                {
                    for(int l=j;l<j+3;l++)
                    {
                        if(board[k][l]!='.') 
                        {
                            if(set.Contains(board[k][l])) 
                                return false;

                            set.Add(board[k][l]);
                        }
                    }
                }
                set.Clear();
            }
        }
        return true;
    }

   
    bool validRowsCols(char[][] board)
    {
        for(int i=0;i<9;i++)
        {
            HashSet<char> set1=new();
            HashSet<char> set2=new();
            for(int j=0;j<9;j++)
            {
                if(board[i][j]!='.') 
                {
                    if(set1.Contains(board[i][j])) 
                        return false;

                    set1.Add(board[i][j]);
                }
                
                if(board[j][i]!='.') 
                {
                    if(set2.Contains(board[j][i])) 
                        return false;

                    set2.Add(board[j][i]);
                }
            }
            set1.Clear();
            set2.Clear();
        }
        return true;
    }

}