class Solution {
    final double EPS = 1e-6;
    public boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();
        for(int card : cards){
            nums.add((double)card);
        }
        return helper(nums);
    }

    boolean helper(List<Double> nums){
        if(nums.size()==1){
            return Math.abs(nums.get(0) - 24.0) < EPS; 
        }

        // Now check for all combinations
        for(int i=0;i<nums.size();i++){
            for(int j=0;j<nums.size();j++){
                if(i==j)continue;
                List<Double> next = new ArrayList<>();
                for(int k=0;k<nums.size();k++){
                    // add remaining cards
                    if(k!=i && k!=j)next.add(nums.get(k));
                }

                for(double val : compute(nums.get(i),nums.get(j))){
                    next.add(val);
                    if(helper(next))
                        return true;
                    next.remove(next.size()-1);
                }
            }
        }
        return false;
    }

    List<Double> compute(double a,double b){
        // make all combinations of a and b;
        List<Double> res = new ArrayList<>();
        res.add(a+b);
        res.add(a-b);
        res.add(b-a);
        res.add(a*b);
        if(Math.abs(a) > EPS)res.add(b/a);
        if(Math.abs(b) > EPS)res.add(a/b);
        return res;
    }
}