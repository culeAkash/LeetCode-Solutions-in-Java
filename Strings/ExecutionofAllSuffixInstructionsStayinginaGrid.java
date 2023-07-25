class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        
        int k = s.length();
        int[] ans = new int[k];

        for(int i=0;i<k;i++){
            int row = startPos[0];
        int col = startPos[1];
            int temp = 0;
            for(int j=i;j<k;j++){
                char ch = s.charAt(j);
                if(ch=='L'){
                    if(col-1>=0){
                        temp++;
                        col--;
                    }else break;
                }else if(ch=='R'){
                    if(col+1<n){
                        temp++;
                        col++;
                    }else break;
                }else if(ch=='U'){
                    if(row-1>=0){
                        temp++;
                        row--;
                    }else break;
                }else if(ch=='D'){
                    if(row+1<n){
                        temp++;
                        row++;
                    }else break;
                }
            }
            ans[i] = temp;
        }

        return ans;
    }
}