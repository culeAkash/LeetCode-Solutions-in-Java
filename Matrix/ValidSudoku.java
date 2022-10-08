class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]!='.'){
                    if(!isValid(board[i][j],i,j,board))
                        return false;
                    }
            }
        }
        return true;
    }
    
    boolean isValid(char c, int row,int col,char[][] board){
        for(int i=0;i<9;i++){
            if(i!=row){
                if(board[i][col]==c){
                    return false;
                }
            }//through entire row
            if(i!=col){
                if(board[row][i]==c){
                    return false;
                }//thourgh entir column
            }
            
            int r = 3*(row/3)+i/3;
            int co = 3*(col/3)+i%3;
            if(r==row && co==col)
                continue;
            else if(board[r][co]==c){
                return false;
            }//through the 3X3 matrix
        }
        return true;
        
    }
}