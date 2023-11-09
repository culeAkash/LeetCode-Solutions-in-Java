class Solution {
    public List<List<Integer>> combinationSum3(int K, int N) {
      List<List<Integer>> res = new ArrayList<>();
        if(K>=N)
            return res;
            
        List<Integer> ans = new ArrayList<>();
        
        helper(res,ans,K,N,1);
        
        return res;
            
    }
    
    public void helper(List<List<Integer>> res,List<Integer> ans,int count,int target,int index){
        if(ans.size()==count){
            if(target==0){
                res.add(new ArrayList<Integer>(ans));
            }
            return;
        }
        
        for(int i=index;i<=9;i++){
            if(i>target)
                break;
                
            ans.add(i);
            helper(res,ans,count,target-i,i+1);
            ans.remove(ans.size()-1);
        }
        
    }
}