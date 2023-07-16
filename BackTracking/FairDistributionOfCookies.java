class Solution {

    int ans = Integer.MAX_VALUE;

    public int distributeCookies(int[] cookies, int k) {
        helper(cookies,0,new int[k]);

        return ans;
    }

    // For first cookie give it to each person check for next cookie bag again
    public void helper(int[] cookies,int start,int[] kids){
        if(start >= cookies.length){
            // calculate the unfairness => max cookie a kid got
            int max = 0;
            for(int kid : kids){
                max =  Math.max(kid,max);
            }
            ans = Math.min(ans,max);
            return;
        }

        // for each cookie consider it to be given to every kid
        for(int i = 0;i<kids.length;i++){
            // consider to cookie from bag[start] given to a kid
            kids[i] += cookies[start];
            // check for next cookie bag
            helper(cookies,start+1,kids);
            //backtrack, so that present cookie bag to be given to next kid
            kids[i] -= cookies[start];
        }
    }
}