class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row_start=0,row_end=matrix.length-1,col_start=0,col_end=matrix[0].length-1;
        int count = 0;
        int row = matrix.length,col=matrix[0].length;
        int max = row*col;
        List<Integer> res = new ArrayList<>();
        while(count<max){
            for(int i=col_start;count<max && i<=col_end;i++){
                res.add(matrix[row_start][i]);
                count++;
            }
            row_start++;
            
            for(int i=row_start;count<max && i<=row_end;i++){
                res.add(matrix[i][col_end]);
                count++;
            }
            col_end--;
            
            for(int i=col_end;count<max && i>=col_start;i--){
                res.add(matrix[row_end][i]);
                count++;
            }
            row_end--;
            
            for(int i=row_end;count<max && i>=row_start;i--){
                res.add(matrix[i][col_start]);
                count++;
            }
            col_start++;
        }
        return res;
    }
}