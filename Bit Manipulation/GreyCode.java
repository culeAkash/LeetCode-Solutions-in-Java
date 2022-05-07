class Solution {
    public List<Integer> grayCode(int n) {
        List<String> res = helper(n);
        List<Integer> ans = new ArrayList<>();
        for(String str:res){
            ans.add(Integer.parseInt(str,2));
        }
        return ans;
    }
    
    private List<String> helper(int n){
        List<String> res= new ArrayList<>();
        if(n==1){
            res.add("0");
            res.add("1");
            return res;
        }
        
        List<String> smallRes = helper(n-1);
        for(int i=0;i<smallRes.size();i++){
            res.add("0" + smallRes.get(i));
        }
        for(int i=smallRes.size()-1;i>=0;i--){
            res.add("1" + smallRes.get(i));
        }
        
        return res;
    }
}