//Recursive
public class Solution {
	public static int matrixMultiplication(int[] arr , int N) {
		return helper(arr,1,N-1);
	}
    
    public static int helper(int[] arr,int start,int end){
        if(start==end)
            return 0;
        int min = Integer.MAX_VALUE;
        for(int partition=start;partition<end;partition++){
            int steps = arr[start-1]*arr[partition]*arr[end] + 
                helper(arr,start,partition) + 
                helper(arr,partition+1,end);
            
            min = Math.min(steps,min);
        }
        return min;
    }
}

//Memoized
import java.util.Arrays;
public class Solution {
	public static int matrixMultiplication(int[] arr , int N) {
        int[][] dp = new int[N][N];
        for(int[]a:dp){
            Arrays.fill(a,-1);
        }
		return helper(arr,1,N-1,dp);
	}
    
//iterative
public class Solution {
	public static int matrixMultiplication(int[] arr , int N) {
		int[][] dp = new int[N][N];
        
        for(int i=N-1;i>=1;i--){
            for(int j=i+1;j<N;j++){
                int mini = Integer.MAX_VALUE;
                for(int k=i;k<j;k++){
                    int steps = arr[i-1]*arr[k]*arr[j] + 
                        dp[i][k] + dp[k+1][j];
                    
                    mini = Math.min(mini,steps);
                }
                dp[i][j] = mini;
            }
        }
        return dp[1][N-1];
	}
}

    public static int helper(int[] arr,int start,int end,int[][] dp){
        if(start==end)
            return 0;
        
        if(dp[start][end]!=-1)
            return dp[start][end];
        int min = Integer.MAX_VALUE;
        for(int partition=start;partition<end;partition++){
            int steps = arr[start-1]*arr[partition]*arr[end] + 
                helper(arr,start,partition,dp) + 
                helper(arr,partition+1,end,dp);
            
            min = Math.min(steps,min);
        }
        return dp[start][end] = min;
    }
}
