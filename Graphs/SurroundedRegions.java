//DFS solution
class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i==0 || j==0 || i==m-1 || j==n-1) && board[i][j]=='O'){
                    dfs(board,m,n,i,j);
                }
            }
        }


        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='T')
                    board[i][j] = 'O';
                else if(board[i][j]=='O')
                    board[i][j] = 'X';
            }
        }
    }

    public void dfs(char[][] grid,int m,int n,int rowNum,int colNum){
        if(rowNum<0 || colNum<0 || rowNum>=m || colNum>=n || grid[rowNum][colNum]=='X' || grid[rowNum][colNum]=='T')
            return;

        grid[rowNum][colNum] = 'T';//mark as visited

        dfs(grid,m,n,rowNum+1,colNum);
        dfs(grid,m,n,rowNum-1,colNum);
        dfs(grid,m,n,rowNum,colNum+1);
        dfs(grid,m,n,rowNum,colNum-1);

    }
}

//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(a[0]);
            int m = Integer.parseInt(a[1]);
            char mat[][] = new char[n][m];
            for(int i=0; i<n; i++)
            {
                String S[] = in.readLine().trim().split(" ");
                for(int j=0; j<m; j++)
                {
                    mat[i][j] = S[j].charAt(0);
                }
            }
            
            Solution ob = new Solution();
            char[][] ans = ob.fill(n, m, mat);
            for(int i = 0;i < n;i++) {
                for(int j = 0;j < m;j++) {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}


//BFS Solution

class Solution{
    static char[][] fill(int n, int m, char grid[][])
    {
        Queue<Pair> visitedSlots = new LinkedList<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0 || i==n-1 || j==m-1){
                    if(grid[i][j]=='O')
                        visitedSlots.offer(new Pair(i,j));
                }
            }
        }
        
        int[] distX = {0,0,1,-1};
        int[] distY = {1,-1,0,0};
        
        while(!visitedSlots.isEmpty()){
            Pair top = visitedSlots.poll();
                grid[top.x][top.y] = 'T';
                for(int i=0;i<4;i++){
                    int x = top.x + distX[i];
                    int y = top.y + distY[i];
                    
                    if(x>=0 && y>=0 && x<grid.length && y<grid[0].length && grid[x][y]=='O'){
                        visitedSlots.offer(new Pair(x,y));
                    
                }
            }
        }
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='O')
                    grid[i][j] = 'X';
                if(grid[i][j]=='T')
                    grid[i][j] = 'O';
            }
        }
        return grid;
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