//recursive
public int maxProfit1(int[] prices) {
        int length = prices.length;
        return helperRecursive(0,length,1,2,prices);
    }
    private int helperRecursive(int day,int noOfDays,int buy,int cap,int[] prices){
        if(day==noOfDays || cap == 0)
            return 0;
        
        if(buy==1)//if buying is allowed two options either buy or not
            return Math.max((0-prices[day])+helperRecursive(day+1,noOfDays,0,cap,prices),helperRecursive(day+1,noOfDays,1,cap,prices));
        
        //if not allowed to buy can have two options sell or not sell
        return Math.max((prices[day])+helperRecursive(day+1,noOfDays,1,cap-1,prices),helperRecursive(day+1,noOfDays,0,cap,prices));
    }
}

//memoized
public class Solution {
	public static int maxProfit(ArrayList<Integer> p, int n) {
		int[] prices =  new int[p.size()];
		for(int i=0;i<p.size();i++)
			prices[i] = p.get(i);
		int length = prices.length;
		int[][][] dp = new int[length][2][3];
		for(int i=0;i<length;i++){
			for(int j=0;j<=1;j++){
				for(int k=0;k<=2;k++){
					dp[i][j][k] = -1;
				}
			}
		}
        return helperMemoized(0,length,1,2,prices,dp);
	}
	
	private static int helperMemoized(int day,int noOfDays,int buy,int cap,int[] prices,int[][][] dp){
        if(day==noOfDays || cap == 0)
            return 0;
        if(dp[day][buy][cap]!=-1)
			return dp[day][buy][cap];
        if(buy==1)//if buying is allowed two options either buy or not
            return dp[day][buy][cap] = Math.max((0-prices[day])+helperMemoized(day+1,noOfDays,0,cap,prices,dp),helperMemoized(day+1,noOfDays,1,cap,prices,dp));
        
        //if not allowed to buy can have two options sell or not sell
        return dp[day][buy][cap] = Math.max((prices[day])+helperMemoized(day+1,noOfDays,1,cap-1,prices,dp),helperMemoized(day+1,noOfDays,0,cap,prices,dp));
    }
}

//iterative
class Solution {
    public int maxProfit(int[] prices){
        int length = prices.length;
        int[][][] dp = new int[length+1][2][3];
        
        //Base cases
        //1. day=length
        for(int buy=0;buy<=1;buy++){
            for(int cap=0;cap<=2;cap++)
                dp[length][buy][cap] = 0;
        }
        //2. cap =0
        for(int day=0;day<length;day++){
            for(int buy=0;buy<=1;buy++)
                dp[day][buy][0] = 0;
        }
        
        for(int day = length-1;day>=0;day--){
            for(int buy=0;buy<=1;buy++){
                for(int cap=1;cap<=2;cap++){
                    if(buy==1){
                        dp[day][buy][cap] = Math.max((0-prices[day])+dp[day+1][0][cap],dp[day+1][1][cap]);
                    }
                    else{
                        dp[day][buy][cap] = Math.max((prices[day])+dp[day+1][1][cap-1],dp[day+1][0][cap]);
                    }
                }
            }
        }
        return dp[0][1][2];
    }