class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int size = n*n;
        int count = 1;
        int row_start=0,row_end = n-1,col_start=0,col_end=n-1;
        
        while(count<=size){
            for(int i=col_start;count<=size && i<=col_end;i++){
                res[row_start][i] = count++;
            }
            row_start++;
            
            for(int i=row_start;count<=size && i<=row_end;i++){
                res[i][col_end] = count++;
            }
            col_end--;
            
            for(int i=col_end;count<=size && i>=col_start;i--){
                res[row_end][i] = count++;
            }
            row_end--;
            
            for(int i=row_end;count<=size && i>=row_start;i--){
                res[i][col_start] = count++;
            }
            col_start++;
        }
        return res;
        
        }
}