class Solution {
    public int numSubmat(int[][] mat) {
        int n = mat[0].length;
        int[] heights = new int[n];
        int res = 0;
        for(int[] row : mat){
            for(int i=0;i<n;i++){
                heights[i] = row[i] == 0 ? 0 : heights[i] + 1;
            }

            Stack<int[]> st = new Stack<>();
            st.push(new int[]{-1,0,-1});

            for(int j=0;j<row.length;j++){
                int h = heights[j];

                while(st.peek()[2] >= h){
                    st.pop();
                }

                int[] top = st.peek();
                int prev = top[1];
                int prevIndex = top[0];
                
                int cur = (j - prevIndex) * h + prev;
                res += cur;
                st.push(new int[]{j,cur,h});
            }
        }
        return res;
    }
}