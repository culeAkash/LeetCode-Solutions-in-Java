class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
       int color = image[sr][sc];
        // int[] moveX = {1,-1,0,0};
        // int[] moveY = {0,0,-1,1};
        
        dfs(image,sr,sc,color,newColor);
        return image;
    }
    
    void dfs(int[][] image,int i,int j,int color,int newColor){
        if(i<0 || i>=image.length || j<0 || j>=image[0].length || image[i][j]!=color || image[i][j]==newColor)
            return;
            
        image[i][j] = newColor;
        
        dfs(image,i+1,j,color,newColor);
        dfs(image,i-1,j,color,newColor);
        dfs(image,i,j+1,color,newColor);
        dfs(image,i,j-1,color,newColor);
        
    }
}