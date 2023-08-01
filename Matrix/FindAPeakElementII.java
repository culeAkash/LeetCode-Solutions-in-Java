class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int start = 0;
        int end = mat[0].length-1;

        while(start<=end){
            int maxRow = 0;
            int midCol = start + (end-start)/2;

            for(int i=0;i<mat.length;i++){
                maxRow = mat[i][midCol] > mat[maxRow][midCol] ? i : maxRow;
            }

            boolean isLeftBig = midCol-1>=start && mat[maxRow][midCol-1]>mat[maxRow][midCol];
            boolean isRightBig = midCol+1<=end && mat[maxRow][midCol+1]>mat[maxRow][midCol];

            if(!isLeftBig && !isRightBig)
                return new int[]{maxRow,midCol};
            else if(isLeftBig)
                end = midCol-1;
            else 
                start = midCol + 1;
        }
        return null;
    }
}