class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int start = matrix[0][0],end = matrix[n-1][n-1];
        
        while(start<end){
            int mid = start + (end-start)/2;
            
            if(count(matrix,mid,n)<k)
                start = mid + 1;
            else
                end = mid;
        }
        return start;
    }
    
    public int count(int[][] matrix,int mid,int n){
        int i= n-1,j=0;
        int count= 0;
        while(i>=0 && j<n){
            if(matrix[i][j]<=mid){
                count+= i+1;
                j++;
            }
            else
                i--;
        }
        return count;
    }
}