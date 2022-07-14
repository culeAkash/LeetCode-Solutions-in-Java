class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for(int i:matchsticks)
            sum+=i;
        
        if(sum%4!=0)
            return false;
        Arrays.sort(matchsticks);
        return helper(matchsticks,matchsticks.length-1,0,0,0,0,sum/4);
    }
    
    public boolean helper(int[] arr,int index,int l,int t,int r,int b,int target){
        if(l==target && t==target && r==target && b==target)
            return true;
        
        if(l>target || t>target || r>target || b>target)
            return false;
        
        int val = arr[index];
        if(helper(arr,index-1,l+val,t,r,b,target))
            return true;
        
        if(helper(arr,index-1,l,t+val,r,b,target))
            return true;
        
        if(helper(arr,index-1,l,t,r+val,b,target))
            return true;
        
        if(helper(arr,index-1,l,t,r,b+val,target))
            return true;
        
        return false;
    }
}