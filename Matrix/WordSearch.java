class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length,col = board[0].length;
        
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(stringSearch(board,word,0,i,j,row,col))
                    return true;
            }
        }
        return false;
    }
    
    public boolean stringSearch(char[][] board,String word,int index,int row,int col,int rowSize,int colSize){
        boolean found = false;
        
        if(row<rowSize && row>=0 && col<colSize && col>=0 && index<word.length() && word.charAt(index)==board[row][col]){
            
            board[row][col] = '0';
             
            index++;
            
            if(index==word.length())
                return true;
            else{
                found = stringSearch(board,word,index,row+1,col,rowSize,colSize) || stringSearch(board,word,index,row,col+1,rowSize,colSize) || stringSearch(board,word,index,row-1,col,rowSize,colSize) || stringSearch(board,word,index,row,col-1,rowSize,colSize);
            }
            board[row][col] = word.charAt(index-1);
        }
        return found;
    }
}