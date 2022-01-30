class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans= new ArrayList<>();
        char[][] board= new char[n][n];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';//initialise as empty
            }
        }
        solve(0,board,ans);
        return ans;
    }
    
    public void solve(int col,char[][] board,List<List<String>> ans){
        if(col==board.length){
            ans.add(construct(board));
            return;
        }
        
        for(int row=0;row<board.length;row++){
            if(validate(row,col,board)){
                board[row][col]='Q';
                solve(col+1,board,ans);
                //backtrack
                board[row][col]='.';
            }
        }
    }
    
    public boolean validate(int row,int col,char[][] board){
        int row1= row;
        int col1=col;
        
        //for checking left
        while(col>=0){
            if(board[row][col]=='Q'){
                return false;
            }
            col--;
        }
        
        row=row1;
        col=col1;
        //chcecking upper diagonal
        while(row>=0 && col>=0){
            if(board[row][col]=='Q'){
                return false;
            }
            row--;
            col--;
        }
        
        row=row1;
        col=col1;
        //checking down diagonal
        while(row<board.length && col>=0){
            if(board[row][col]=='Q'){
                return false;
            }
            row++;
            col--;
        }
        
        return true;
    }
    
    public List<String> construct(char[][] board){
        List<String> res= new ArrayList<>();
        for(int i=0;i<board.length;i++){
            String s= new String(board[i]);
            res.add(s);
        }
        return res;
    }
}
