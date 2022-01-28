class Solution {
    public List<List<Integer>> permute(int[] arr) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> ds= new ArrayList<>();
        boolean[] visited= new boolean[arr.length];
        getPermutations(arr,ds,ans,visited);
        return ans;
    }
    
     private static void getPermutations(int[] arr, List<Integer> ds, List<List<Integer>> ans, boolean[] visited) {
        if(arr.length==0){
            return;
        }

        //all indices are selected
        if(ds.size()==arr.length){
            ans.add(new ArrayList<>(ds));
        }

        for(int i=0;i<arr.length;i++){
            if(!visited[i]){
                visited[i]=true;
                ds.add(arr[i]);
                getPermutations(arr, ds, ans, visited);
                ds.remove(ds.size()-1);
                visited[i]=false;
            }
        }
    }

}