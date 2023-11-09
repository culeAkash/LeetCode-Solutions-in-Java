class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        helper("",0,0,n,res,0);
        return res;
    } 

    public static void helper(String ans,int open,int close,int n,List<String> res,int count){
        if(count==n){
            res.add(ans);
            return;
        }

        if(open<n){
            helper(ans+"(",open+1,close,n,res,count);
        }

        if(open!=0 && close<open){
            helper(ans+")",open,close+1,n,res,count+1);
        }
    }
}