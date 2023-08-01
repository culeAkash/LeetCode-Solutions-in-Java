class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp= new ArrayList<>();
        // temp.add(1);
            helper(ans,temp,n,k,1);
        
        return ans;
    }

    public void helper(List<List<Integer>> ans,List<Integer> temp,int n,int k,int p){
        if(temp.size()==k){
            // temp.add(p);
            ans.add(new ArrayList<>(temp));
            // temp.remove(temp.size()-1);
            return;
        }

        // if(n+1-p < k)
        //     return;

        // for(int t : temp)
        //     System.out.print(t+" ");
        // System.out.println();

        // temp.add(p);
        for(int num=p;num<=n;num++){
            // System.out.println(num);
            temp.add(num);
            helper(ans,temp,n,k,num+1);
            temp.remove(temp.size()-1);
        }

        
    }
}