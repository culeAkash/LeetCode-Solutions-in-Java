//DFS Solution
class Solution {
    public int numEnclaves(int[][] grid) {
        //No of enclaves using DFS

        int m = grid.length;
        int n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i==0 || j==0 || i==m-1 || j==n-1) && grid[i][j]==1){
                    dfs(grid,m,n,i,j);
                }
            }
        }

        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1)
                    count++;
            }
        }
        return count;
    }

    public void dfs(int[][] grid,int m,int n,int rowNum,int colNum){
        if(rowNum<0 || colNum<0 || rowNum>=m || colNum>=n || grid[rowNum][colNum]==0)
            return;

        grid[rowNum][colNum] = 0;//mark as visited

        dfs(grid,m,n,rowNum+1,colNum);
        dfs(grid,m,n,rowNum-1,colNum);
        dfs(grid,m,n,rowNum,colNum+1);
        dfs(grid,m,n,rowNum,colNum-1);

    }
}

//BFS Solution
//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.numberOfEnclaves(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int numberOfEnclaves(int[][] grid) {

        Queue<Pair> q = new LinkedList<>();
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i==0 || j==0 || i==grid.length - 1 || j == grid[0].length - 1){
                    if(grid[i][j]==1)
                        q.offer(new Pair(i,j));
                }
            }
        }
        
        int[] distX = {0,0,1,-1};
        int[] distY = {1,-1,0,0};
        
        while(!q.isEmpty()){
            Pair top = q.poll();
                grid[top.x][top.y] = 0;
                for(int i=0;i<4;i++){
                    int x = top.x + distX[i];
                    int y = top.y + distY[i];
                    
                    if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]==1){
                        q.offer(new Pair(x,y));
                    
                }
            }
        }
        
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1)
                    count++;
            }
        }
        return count;
    }
}

class Pair{
    int x;
    int y;
    
    public Pair(int x,int y){
        this.x = x;
        this.y = y;
    }
}