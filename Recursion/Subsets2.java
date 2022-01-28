class Solution {
    public List<List<Integer>> subsetsWithDup(int[] arr) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> ds= new ArrayList<>();
        Arrays.sort(arr);
        getSubsets(arr,arr.length,ans,ds,0);
        return ans;
    }
    
    private static void getSubsets(int[] arr, int length, List<List<Integer>> ans, List<Integer> ds, int index) {
        if(length==0){
            return;
        }
        
        if(ans.contains(ds)){
            return;
        }

        //To get all the possible subsets 
        ans.add(new ArrayList<>(ds));

        for(int i=index;i<length;i++){
            if(i!=index && arr[i]==arr[i-1]){
                continue;
            }//avoid duplication

            //pick unique index
            ds.add(arr[i]);
            getSubsets(arr, length, ans, ds, i+1);
            //backtrack
            ds.remove(ds.size()-1);

        }
    }
}