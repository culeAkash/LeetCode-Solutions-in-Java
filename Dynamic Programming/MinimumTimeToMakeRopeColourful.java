class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = colors.length();
        return helper(colors,n-1,n-2,neededTime);
    }
    public int helper(String colors,int i,int j,int[] time){
        if(i<0 || j<0)
            return 0;
        
        //compare
        //if same
        int cost=0;
        if(colors.charAt(i)==colors.charAt(j)){
            if(time[i]<time[j]){
                cost = time[i] + helper(colors,j,j-1,time);
            }
            else{
                cost= time[j] + helper(colors,i,j-1,time);
            }
        }
        else
            cost = helper(colors,j,j-1,time);
        return cost;
    }
}