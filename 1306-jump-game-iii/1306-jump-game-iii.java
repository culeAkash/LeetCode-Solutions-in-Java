class Solution {
    public boolean canReach(int[] arr, int start) {
        int N = arr.length;
        int[] visited = new int[N];

        visited[start] = 1;
        Queue<Integer> q = new LinkedList<>();

        q.offer(start);

        while(!q.isEmpty()){
            int top = q.poll();

            if(arr[top]==0)return true;

            if(top + arr[top] < N && visited[top + arr[top]]==0){
                q.offer(top + arr[top]);
                visited[top + arr[top]] = 1;
            }

            if(top - arr[top] >= 0 && visited[top - arr[top]]==0){
                q.offer(top - arr[top]);
                visited[top - arr[top]] = 1;
            }
        }

        return false;
    }
}