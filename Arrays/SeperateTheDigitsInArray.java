class Solution {
    public int[] separateDigits(int[] nums) {
        List<Integer> res = new ArrayList<>();
        
        for(int num :nums){
            seperate(num,res);
        }
        int[] ans = new int[res.size()];
        int i = 0;
        for(int num : res)
            ans[i++] = num;
        return ans;
    }
    
    public void seperate(int n,List<Integer> res){
        List<Integer> sm = new ArrayList<>();
        while(n>0){
            int r = n%10;
            
            sm.add(r);
            n /= 10;
        }
        
        Collections.reverse(sm);
        res.addAll(sm);
    }
}