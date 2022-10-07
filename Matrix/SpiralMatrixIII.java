class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] ans = new int[rows*cols][2];
        int topr = rStart-1;
        int bottomr =rStart+1;
        int leftc = cStart-1;
        int rightc =cStart+1;
        ans[0][0] = rStart;
        ans[0][1]= cStart;
   return path(rows, cols, rStart, cStart, topr, bottomr, leftc, rightc, ans, 1);
}
int[][] path(int rows, int cols, int rStart, int cStart, int topr, int bottomr, int leftc, int rightc, int[][] mat, int x){
    
    if(topr<0 && bottomr>rows-1 && leftc<0 && rightc>cols-1){
        return mat;
    }
    
    for(int i = topr+1 ; i <= bottomr; i++){
        if(i<rows && i>=0 && rightc>=0 && rightc<cols){
            mat[x][0]=i;
            mat[x][1]=rightc;
            x +=1;
        }
    }
    for(int i =rightc-1; i>= leftc ; i--){
        if(i>=0 && i<cols && bottomr>=0 && bottomr < rows){
            mat[x][0]=bottomr;
            mat[x][1]=i;
            x +=1;
        }
    }
    for(int i =bottomr-1; i>=topr; i--){
        if(i<rows && i>=0 && leftc >= 0 && leftc<cols){
            mat[x][0]=i;
            mat[x][1]=leftc;
            x +=1;
        }
    }
    for(int i = leftc+1 ; i<= rightc; i++){
        if(i<cols && i>=0 && topr>=0 && topr<rows){
            mat[x][0]=topr;
            mat[x][1]=i;
            x +=1;
        }
    }
    return path(rows, cols, rStart+1, cStart, topr-1, bottomr+1, leftc-1, rightc+1, mat, x);
        
}
}