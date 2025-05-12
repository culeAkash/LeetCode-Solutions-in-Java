class Solution {
    public int minOperations(int[] nums) {
        Stack<Integer> st = new Stack<>();

        int count = 0;

        for(int num : nums){
            while(!st.empty() && st.peek() > num)
                st.pop();

            if(st.empty() || st.peek() < num){
                if(num > 0){
                    count++;
                    st.push(num);
                }
            }
        }
        return count;
    }
}