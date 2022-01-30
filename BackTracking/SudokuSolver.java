class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
        }
    
    boolean solve(char[][] board){
        //Iterating through thr entire board
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                //if any empty space is found
                if(board[i][j]=='.'){
                    for(char c='1';c<='9';c++){
                        //for each possible number
                        if(isValid(c,i,j,board)){
                            board[i][j]=c;//if valid put the number to it
                            //call recursion again
                            if(solve(board)){
                                return true;//if true the sudoku solved no need to backtrack
                            }
                            else{
                                //backtrack
                                board[i][j]='.';
                            }
                            
                        }
                    }
                    //if all numbers are checked and none are valid
                    return false;
                }
            }
    }
        return true;
    }
    
    boolean isValid(char c, int row,int col,char[][] board){
        for(int i=0;i<9;i++){
            if(board[i][col]==c){
                return false;
            }//through entire row
            if(board[row][i]==c){
                return false;
            }//thourgh entir column
            
            if(board[3*(row/3)+i/3][3*(col/3)+i%3]==c){
                return false;
            }//through the 3X3 matrix
        }
        return true;
        
    }
}
