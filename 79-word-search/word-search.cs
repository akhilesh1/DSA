public class Solution {
    bool ans=false;
    public bool Exist(char[][] board, string word) {
        for(int i = 0; i < board.Length; i++)
            for(int j = 0; j < board[0].Length; j++)
                Backtrack(board, word, i, j);
        return ans;
    }

    void Backtrack(char[][] board, string word,int i,int j)
    {
        if(string.IsNullOrEmpty(word))
        {
            ans=true;
            return;
        }
        int N=board.Length;
        int M=board[0].Length;
        //if(i < 0 || i >= N || j < 0 || j >= M) return;
        if(board[i][j] == '#') return;
        
        
        
        //what is the current position
        //make sure this does not go in same dirction when originated? skip same letter
        if(word[0]==board[i][j])
        {
             if(word.Length == 1)  // Found the last character!
            {
                ans = true;
                return;
            }

            char tmp=board[i][j];
            board[i][j]='#';
        //run options
            if(i<N-1)
            {
                Backtrack(board,word.Substring(1),i+1,j);

            }
            if(j<M-1)
                Backtrack(board,word.Substring(1),i,j+1);

            if(i>0)
                Backtrack(board,word.Substring(1),i-1,j);
            if(j>0)
                Backtrack(board,word.Substring(1),i,j-1);
            
            board[i][j]=tmp;
        }

    }



}