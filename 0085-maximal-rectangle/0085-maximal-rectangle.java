class Solution {
    public int maximalRectangle(char[][] matrix) {
      int n = matrix.length;
        int m = matrix[0].length;
        int maxi = 0;
        int[] histogram = new int[m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                histogram[j] = matrix[i][j]=='0' ? 0 : histogram[j] + 1;
            }
            int rectArea = maximumRectHistogram(histogram);
            maxi = Math.max(rectArea,maxi);
        }

        return maxi;
    }


    public int maximumRectHistogram(int[] arr){
        Stack<Integer> st = new Stack<>();
        int maxi = 0;

        for(int i=0;i<arr.length;i++){
            while(!st.empty() && arr[st.peek()]>=arr[i]){
                int val = arr[st.pop()];
                int nse = i;
                int pse = st.empty() ? -1 : st.peek();
                int area = val * (nse - pse - 1);
                maxi = Math.max(area,maxi);
            }
            st.push(i);
        }

        while(!st.empty()){
            int val = arr[st.pop()];
            int nse = arr.length;
            int pse = st.empty() ? -1 : st.peek();
            int area = val * (nse - pse - 1);
            maxi = Math.max(area,maxi);
        }

        return maxi;
    }
}