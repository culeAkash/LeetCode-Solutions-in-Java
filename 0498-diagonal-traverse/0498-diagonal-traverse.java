class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[m*n];
        int rowPath = -1,colPath=1;

        int count = 0;
        int row = 0,col = 0;
        while(count < (m*n)){
            res[count] = mat[row][col];

            int newRow = row + rowPath;
            int newCol = col + colPath;

            // System.out.println(newRow + " " + newCol);

            if(newRow < 0 || newCol < 0 || newRow >= m || newCol >=n){
                rowPath *= -1;
                colPath *= -1;

                if(newCol >= n){
                    row = newRow + 2;
                    col = n-1;
                }else if(newRow >= m){
                    col = newCol + 2;
                    row = m-1;
                }else if(newCol < 0){
                    col = 0;
                    row = newRow;
                }else{
                    row = 0;
                    col = newCol;
                }
            }else{
                row = newRow;
                col = newCol;
            }
            count++;
            // System.out.println(row + " " + col);
        }
        return res;
    }
}