class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int size = m * n;
        int count = 0;
        int prev = 0;
        int rowStart = 0,rowEnd = m - 1;
        int colStart = 0,colEnd = n - 1;
        while(count < size){
            int presCycleSize = 2 * ((m-1) + (n-1));
            int tempK = k % presCycleSize;// these many rotations, we have to do

            

            while(tempK-- > 0){
                prev = grid[rowStart][colStart+1];
                int r1 = rowStart,r2 = rowEnd;
                int c1 = colStart,c2 = colEnd;

                int index = r1;

                while(index<=r2){
                    int t = grid[index][c1];
                    grid[index][c1] = prev;
                    prev = t;
                    index++;
                }

                c1++;
                index = c1;

                while(index<=c2){
                    int t = grid[r2][index];
                    grid[r2][index] = prev;
                    prev = t;
                    index++;
                }

                r2--;
                index = r2;

                while(index>=r1){
                    int t = grid[index][c2];
                    grid[index][c2] = prev;
                    prev = t;
                    index--;
                }

                c2--;
                index = c2;
                while(index>=c1){
                    int t = grid[r1][index];
                    grid[r1][index] = prev;
                    prev = t;
                    index--;
                }

            }

            count += presCycleSize;
            rowStart++;
            rowEnd--;
            colStart++;
            colEnd--;
            m -= 2;
            n -=2;
        }

        return grid;
    }
}