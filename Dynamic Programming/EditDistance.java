class Solution {
    public int minDistance(String word1, String word2) {
        int n= word1.length();
        int m = word2.length();
        
        int[] prev= new int[m+1];
        
        
        for(int i=0;i<=m;i++){
            prev[i] = i;
        }
        
        for(int i=1;i<=n;i++){
            int[] curr= new int[m+1];
            curr[0]=i;
            for(int j=1;j<=m;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1))
                   curr[j] = prev[j-1];
                else{
                    //if not matches
                    int insert =  curr[j-1];
                    int delete = prev[j];
                    int replace =  prev[j-1];
                    curr[j] = 1+ Math.min(insert,Math.min(delete,replace));
                }  
            }
            prev=curr;
        }
        return prev[m];
    }
}