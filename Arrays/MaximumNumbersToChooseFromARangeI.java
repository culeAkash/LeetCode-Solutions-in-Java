class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> set = new HashSet<>();
        
        for(int num : banned)
            set.add(num);
        
        int res = 0;
        int num = 1;
        int count = 0;
        while(num <= n){
            if(!set.contains(num)){
                res += num;
                if(res<=maxSum)
                    count++;
            }
            num++;
        }
        return count;
    }
}