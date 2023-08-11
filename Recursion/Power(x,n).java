class Solution {
    public double myPow(double x, int n) {
        double ans[] = {1.0};

        long m = n;

        if(m<0)m = m * -1;

        helper(m,x,ans);

        if(n<0)ans[0] = 1.0/ans[0];

        return ans[0];
    }

    public void helper(long m,double x,double[] ans){
        if(m==0)
            return;

        if(m%2==1){
            ans[0] = ans[0] * x;
            m = m-1;
        }
        else{
            x = x * x;
            m = m/2;
        }

        helper(m,x,ans);
    }
}