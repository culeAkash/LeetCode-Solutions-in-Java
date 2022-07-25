class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0)
            return false;
        
        int i = 0;
        
        while(i<matrix.length){
            if(matrix[i][0]<=target && matrix[i][matrix[0].length-1]>=target){
                //binary search
                int start = 0;
                int end = matrix[0].length -1 ;
                int mid = 0;
                while(start<=end){
                    mid = (start+end)/2;
                    if(matrix[i][mid]==target)
                        return true;
                    
                    if(matrix[i][mid]<target)
                        start= mid + 1;
                    else
                        end = mid-1;
                }
            }
            else if(matrix[i][0]>target)
                return false;
            i++;
        }
        
        return false;
    }
}