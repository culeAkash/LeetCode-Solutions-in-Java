class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix.length==0){
            return;
        }
        HashMap<Pair,Boolean> hm= new HashMap<>();
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    hm.put(new Pair(i,j),true);
                }
            }
        }
        for(Map.Entry<Pair,Boolean> e:hm.entrySet()){
            Pair temp= e.getKey();
            int r= temp.row;
            int c=temp.col;
            for(int i=0;i<matrix[0].length;i++){
                matrix[r][i]=0;
            }
            for(int i=0;i<matrix.length;i++){
                matrix[i][c]=0;
            }
            
            
        }
    }
}

class Pair{
    int row;
    int col;
    
    Pair(int r,int c){
        row=r;
        col=c;
    }
}
