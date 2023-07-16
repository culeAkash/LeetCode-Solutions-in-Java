class Solution {
    public int longestSubsequence(int[] arr, int difference) {

        Map<Integer,Integer> map = new HashMap<>();

        int ans = 1;

        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i] - difference)){
                map.put(arr[i],map.get(arr[i]-difference)+1);
            }
            else{
                map.put(arr[i],1);
            }

            ans = Math.max(ans,map.get(arr[i]));
        }

        return ans;
    }

    public int helper(int[] arr,int index,int prev ,int k){
        if(index>=arr.length)
            return 0;

        int take=0,notTake = 0;

        if(prev==-10000){
            take = 1 + helper(arr,index+1,arr[index],k);
            notTake = helper(arr,index+1,prev,k);
        }
        else{
            notTake = helper(arr,index+1,prev,k);
            if(arr[index] - prev == k){
                take = 1 + helper(arr,index+1,arr[index],k);
            }
        }

        return Math.max(take,notTake);
    }
}