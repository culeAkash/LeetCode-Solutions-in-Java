class Solution {
    public int largestMagicSquare(int[][] grid) {
        int M = grid.length;
        int N = grid[0].length;

        int[][] prefixRow = new int[M][N];
        int[][] prefixCol = new int[M][N];
        int[][] prefixLeftDiagonal = new int[M][N];
        int[][] prefixRightDiagonal = new int[M][N];

        for(int row =0;row<M;row++){
            for(int col=0;col<N;col++){
                if(col==0)prefixRow[row][col]=grid[row][col];
                else prefixRow[row][col] = grid[row][col] + prefixRow[row][col-1];

                if(row==0)prefixCol[row][col] = grid[row][col];
                else prefixCol[row][col] = grid[row][col] + prefixCol[row-1][col];

                if(row==0 || col==0)prefixLeftDiagonal[row][col] = grid[row][col];
                else prefixLeftDiagonal[row][col] += grid[row][col] + prefixLeftDiagonal[row-1][col-1];

                if(row==0 || col == N-1)prefixRightDiagonal[row][col] = grid[row][col];
                else prefixRightDiagonal[row][col] = grid[row][col] + prefixRightDiagonal[row-1][col+1];

            }
        }

        // for(int row =0;row<M;row++){
        //     System.out.println();
        //     for(int col=0;col<N;col++){
        //         System.out.print(prefixRightDiagonal[row][col] + " ");
        //     }
        // }



        int maxSize = 1;

        for(int row =0;row<M;row++){
            for(int col=0;col<N;col++){
                int row1 = row;
                int col1 = col;

                while(row1 < M && col1 < N){
                    int rowSum = -1;
                    for(int r=row;r<=row1;r++){
                        int sum = prefixRow[r][col1] - (col==0 ? 0 : prefixRow[r][col-1]);
                        if(rowSum==-1)rowSum = sum;
                        else if(rowSum!=sum){
                            rowSum=-1;
                            break;
                        }
                    }
                    int colSum = -1;
                    for(int c=col;c<=col1;c++){
                        int sum = prefixCol[row1][c] - (row==0 ? 0 : prefixCol[row-1][c]);
                        if(colSum==-1)colSum = sum;
                        else if(colSum!=sum){
                            colSum=-1;
                            break;
                        }
                    }

                    int leftDiagonalSum = prefixLeftDiagonal[row1][col1] - (row==0 || col==0 ? 0 : prefixLeftDiagonal[row-1][col-1]);

                    int rightDiagonalSum = prefixRightDiagonal[row1][col] - (row==0 || col1==N-1 ? 0 : prefixRightDiagonal[row-1][col1+1]);

                    if(rowSum!=-1 && colSum!=-1 && (rowSum==colSum && colSum==leftDiagonalSum && leftDiagonalSum==rightDiagonalSum)){
                        maxSize = Math.max(maxSize,(row1-row+1));
                    }

                    row1++;
                    col1++;
                }
            }
        }

        return maxSize;
    }
}