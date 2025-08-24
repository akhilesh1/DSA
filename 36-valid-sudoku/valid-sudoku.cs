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
                        if(board[k][l]=='.') continue;
                        if(set.Contains(board[k][l])) return false;

                        set.Add(board[k][l]);
                    }
                }
            }
        }
        return true;
    }

    bool validRowsCols(char[][] board)
    {
        for(int i=0;i<9;i++)
        {
            HashSet<char> set1=new(); // for rows
            HashSet<char> set2=new(); // for columns
            for(int j=0;j<9;j++)
            {
                // Check row
                if(board[i][j] != '.')
                {
                    if(set1.Contains(board[i][j])) return false;
                    set1.Add(board[i][j]);
                }
                
                // Check column
                if(board[j][i] != '.')
                {
                    if(set2.Contains(board[j][i])) return false;
                    set2.Add(board[j][i]);
                }
            }
        }
        return true;
    }
}