class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> st = new Stack<>();
        st.push(nums[0]);

        for(int index=1;index < nums.length;index++){
            int top = st.pop();
            int curr = nums[index];

            int gcd = gcd(top,curr);
            boolean flag = false;

            while(gcd > 1){
                int lcm = (int)(((long)(top) * (long)(curr))/gcd);
                curr = lcm;
                if(st.empty()){
                    flag = true;
                    break;
                }
                top = st.pop();
                gcd = gcd(curr,top);
            }

            if(!flag){  
                st.push(top);
            }
            st.push(curr);

        }

        List<Integer> ans = new ArrayList<>();
        while(!st.empty()){
            ans.add(0,st.pop());
        }

        return ans;
    }

    int gcd(int a,int b){
        return b == 0 ? a : gcd(b, a % b);
    }
}