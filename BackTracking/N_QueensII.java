class Solution {
    public int totalNQueens(int n) {
        int[][] board = new int[n][n];
        return helper(0,n,board);
    }
    
    int helper(int row,int n,int[][] board){
        if(row==n)
            return 1;
        
        int count = 0;
        
        for(int i=0;i<n;i++){
            if(isValid(row,i,board)){
                board[row][i] = 1;
                count += helper(row+1,n,board);
                board[row][i] = 0;
            }
        }
        return count;
    }
    
    boolean isValid(int row,int col,int[][] board){
        //check upwards
        int i = row,j = col;
        while(i>=0){
            if(board[i][col]!=0)
                return false;
            i--;
        }
        
        i=row;
        while(i>=0 && j>=0){
            if(board[i--][j--]!=0)
                return false;
        }
        i=row;
        j=col;
        while(i>=0 && j<board[0].length){
            if(board[i--][j++]!=0)
                return false;
        }
        return true;
    }
}