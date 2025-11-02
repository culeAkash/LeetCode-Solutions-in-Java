class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];

        for(int[] wall : walls){
            grid[wall[0]][wall[1]] = 1;
        }

        for(int[] guard : guards){
            grid[guard[0]][guard[1]] = 2;
        }
        
        int val = 0;
        for(int i=0;i<m;i++){
            val = 0;
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    val = -1;
                }else if(grid[i][j]==1){
                    val = 0;
                }else if(grid[i][j]==0){
                    grid[i][j] = val;
                }
            }
        }

        // for(int row[] : grid){
        //     for(int col : row){
        //         System.out.print(col + " ");
        //     }
        //     System.out.println();
        // }
        


        
        for(int j=0;j<n;j++){
            val = 0; 
            for(int i=0;i<m;i++){
                if(grid[i][j]==2){
                    val = -1;
                }else if(grid[i][j]==1){
                    val = 0;
                }else if(grid[i][j]==0){
                    grid[i][j] = val;
                }
            }
        }

        // for(int row[] : grid){
        //     for(int col : row){
        //         System.out.print(col + " ");
        //     }
        //     System.out.println();
        // }

        
        for(int j=n-1;j>=0;j--){
            val = 0;
            for(int i=m-1;i>=0;i--){
                if(grid[i][j]==2){
                    val = -1;
                }else if(grid[i][j]==1){
                    val = 0;
                }else if(grid[i][j]==0){
                    grid[i][j] = val;
                }
            }
        }

        
        for(int i=m-1;i>=0;i--){
            val = 0;
            for(int j=n-1;j>=0;j--){
                if(grid[i][j]==2){
                    val = -1;
                }else if(grid[i][j]==1){
                    val = 0;
                }else if(grid[i][j]==0){
                    grid[i][j] = val;
                }
            }
        }

        int ans = 0;
        for(int row[] : grid){
            for(int col : row){
                if(col==0)ans++;
            }
        }

        return ans;
    }
}