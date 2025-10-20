class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        for(String ops : operations){
            if(ops.charAt(0)=='+' || ops.charAt(2)=='+'){
                ans++;
            }else{
                ans--;
            }
        }
        return ans;
    }
}