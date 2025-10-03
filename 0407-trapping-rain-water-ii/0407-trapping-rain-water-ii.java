class Solution {
    public int trapRainWater(int[][] heightMap) {
        int M = heightMap.length;
        int N = heightMap[0].length;

        int[][] dir = {{1,-1,0,0},{0,0,1,-1}};

        PriorityQueue<Cell> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[M][N];

        // add the boundary to the pq and mark them as visited
        // add both start and end row
        for(int j=0;j<N;j++){
            pq.offer(new Cell(heightMap[0][j],0,j));
            pq.offer(new Cell(heightMap[M-1][j],M-1,j));
            visited[0][j] = visited[M-1][j] = true;
        }

        // add both start and end col
        for(int i=0;i<M;i++){
            pq.offer(new Cell(heightMap[i][0],i,0));
            pq.offer(new Cell(heightMap[i][N-1],i,N-1));
            visited[i][0] = visited[i][N-1] = true;
        }

        int res = 0;
        while(!pq.isEmpty()){
            Cell top = pq.poll();
            for(int d=0;d<4;d++){
                int nextRow = top.row + dir[0][d];
                int nextCol = top.col + dir[1][d];

                if(isValid(nextRow,nextCol,M,N) && !visited[nextRow][nextCol]){
                    if(top.value > heightMap[nextRow][nextCol]){
                        res += top.value - heightMap[nextRow][nextCol];
                    }

                    pq.offer(new Cell(
                        Math.max(top.value,heightMap[nextRow][nextCol]),
                        nextRow,nextCol
                    ));

                    visited[nextRow][nextCol] = true;
                }
            }
        }

        return res;


    }

    private boolean isValid(int row,int col,int M,int N){
        return row >=0 && col >=0 && row < M && col < N;
    }
}

class Cell implements Comparable<Cell>{
    int value;
    int row;
    int col;

    public Cell(int val,int row,int col){
        this.value = val;
        this.row = row;
        this.col = col;
    }

    public int compareTo(Cell other){
        return this.value - other.value;
    }

}