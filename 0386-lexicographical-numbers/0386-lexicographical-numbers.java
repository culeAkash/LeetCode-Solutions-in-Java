class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();

        for(int i=1;i<10;i++){
            helper(ans,n,i);
        }

        return ans;
    }

    void helper(List<Integer> ans,int N,int t){
        if(t > N)return;

        ans.add(t);

        for(int i=0;i<10;i++){
            int res = t * 10 + i;
            helper(ans,N,res);
        }
    }
}