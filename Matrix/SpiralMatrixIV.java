class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        int rowStart = 0,rowEnd = m-1,colStart = 0,colEnd= n-1;
        int count = 1;
        while(count<=m*n){
            for(int i=colStart;i<=colEnd && count<=m*n;i++){
                if(head==null)
                    res[rowStart][i] = -1;
                else{
                    res[rowStart][i] = head.val;
                    head=head.next;
                }
                count++;
            }
            rowStart++;
            
            for(int i= rowStart;i<=rowEnd && count<=m*n;i++){
                if(head==null)
                    res[i][colEnd] = -1;
                else{
                    res[i][colEnd] = head.val;
                    head=head.next;
                }
                count++;
            }
            colEnd--;
            
            for(int i=colEnd;i>=colStart && count<=m*n;i--){
                if(head==null)
                    res[rowEnd][i] = -1;
                else{
                    res[rowEnd][i] = head.val;
                    head=head.next;
                }
                count++;
            }
            rowEnd--;
            
            for(int i= rowEnd;i>=rowStart && count<=m*n;i--){
                if(head==null)
                    res[i][colStart] = -1;
                else{
                    res[i][colStart] = head.val;
                    head=head.next;
                }
                count++;
            }
            colStart++;
            
        }
        return res;
    }
}