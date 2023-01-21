class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> temp = new ArrayList<>();
        recursive(nums,0,nums.length,ans,temp,-102);
        // System.out.println(ans);
        List<List<Integer>> res = new ArrayList<>();

        for(List<Integer> t : ans){
            if(t.size()>=2)
             res.add(t);
        }

        return res;
    }

    void recursive(int[] nums,int index,int n,Set<List<Integer>> ans,List<Integer> temp,int min){
        if(index==n){
            ans.add(new ArrayList<Integer>(temp));
            return;
        }

        recursive(nums,index+1,n,ans,temp,min);
        if(index==0 || min<=nums[index]){
            temp.add(nums[index]);
            recursive(nums,index+1,n,ans,temp,nums[index]);
            temp.remove(temp.size()-1);
        }

    }
}