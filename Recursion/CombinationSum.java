class Solution {
    public List<List<Integer>> combinationSum(int[] arr, int sum) {
        List<List<Integer>> comb= new ArrayList<List<Integer>>();
        ArrayList<Integer> adj= new ArrayList<Integer>();
        helper(arr,comb,adj,sum,0,arr.length);
        return comb;
    }
    
    public void helper(int[] arr,List<List<Integer>> comb,List<Integer> adj,int sum, int start, int size){
        if(start==size){
            if(sum==0){
                comb.add(new ArrayList<>(adj));
            }
            return;
        }
        
        // picking
        if(arr[start]<=sum){
            adj.add(arr[start]);
            helper(arr,comb,adj,sum-arr[start],start,size);
            //backtrack
            adj.remove(adj.size()-1);
        }
        
        //not pick
        helper(arr,comb,adj,sum,start+1,size);
        
    }
}
