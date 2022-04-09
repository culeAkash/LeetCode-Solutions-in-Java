class Solution {
    public int[] countBits(int n) {
      int[] res= new int[n+1];
        
        for(int i=0;i<=n;i++){
            res[i]= solve(i);
        }
        return res;
    }
    
    public int solve(int i){
        if(i<=1)
            return i;
        
        if(i%2==0)
            return solve(i/2);
        return 1+solve(i/2);
    }
}