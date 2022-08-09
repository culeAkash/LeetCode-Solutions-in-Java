class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(arr);
        
        for(int i=0;i<arr.length-1;i++){
            minDiff = Math.min(minDiff,Math.abs(arr[i+1]-arr[i]));
        }
        List<List<Integer>> res = new ArrayList<>();
        
        for(int i=0;i<arr.length-1;i++){
            if(Math.abs(arr[i+1]-arr[i])==minDiff){
                List<Integer> sm = new ArrayList<>();
                sm.add(arr[i]);
                sm.add(arr[i+1]);
                res.add(sm);
            }
        }
        return res;
        
    }
}