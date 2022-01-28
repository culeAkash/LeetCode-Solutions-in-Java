class Solution {
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        List<List<Integer>> ans= new ArrayList<>();
        Arrays.sort(arr);//first we have to sort it to avoid duplication
        helper(arr,target,0,ans,new ArrayList<Integer>(),arr.length);
        return ans;
    }
    
    public  void helper(int[] arr, int target, int index, List<List<Integer>> ans, List<Integer> arrayList,
            int length) {
                if(target==0){
                    ans.add(new ArrayList<>(arrayList));
                    return;
                }

                //Now we have to pick from all the elements to get the first element and avoid duplication
                for(int i=index;i<arr.length;i++){
                    //if the element is greater than the target then elements after that will also be greater or equal so won't pick any further
                    if(arr[i]>target){
                        break;
                    }
                    if(i>index && arr[i]==arr[i-1]){
                        continue;
                    }//Avoid duplication

                    //Now if legal element choose the element
                    arrayList.add(arr[i]);
                    helper(arr, target-arr[i], i+1, ans, arrayList, length);
                    arrayList.remove(arrayList.size()-1);
                }
    }
}
