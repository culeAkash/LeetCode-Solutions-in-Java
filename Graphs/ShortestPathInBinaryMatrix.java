class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        
        int[][] distance = new int[grid.length][grid[0].length];
        
        for(int[] dist : distance)
            Arrays.fill(dist,Integer.MAX_VALUE);
            
        
        //int[0] = x int[1] = y int[2] = distance
        if(grid[0][0]==0){
            q.add(new int[]{0,0,0});
            distance[0][0] = 0;
        }
        
        int[] distX = {0,0,1,-1,1,-1,1,-1};
        int[] distY = {1,-1,0,0,-1,1,1,-1};
        
        while(!q.isEmpty()){
            int[] triplet = q.poll();
            
            int row = triplet[0];
            int col = triplet[1];
            int dist = triplet[2];
            
            for(int i =0;i<8;i++){
                int nextR = row + distX[i];
                int nextC = col + distY[i];
                
                if(nextR>=0 && nextR<grid.length && nextC>=0 && nextC<grid[0].length && grid[nextR][nextC]==0){
                    int newDist = dist + 1;
                    
                    if(distance[nextR][nextC]>newDist){
                        distance[nextR][nextC] = newDist;
                        q.offer(new int[]{nextR,nextC,newDist});
                    }
                }
            }
        }
        
        if(distance[grid.length-1][grid[0].length-1]==Integer.MAX_VALUE)
            return -1;
            
        return distance[grid.length-1][grid[0].length-1]+1;
    }
}