class Solution {
    public int[] getOrder(int[][] tasksTemp) {

        int[][] tasks = new int[tasksTemp.length][3];

        for(int i=0;i<tasksTemp.length;i++){
            tasks[i][0] = tasksTemp[i][0];
            tasks[i][1] = tasksTemp[i][1];
            tasks[i][2] = i;
        }

        Arrays.sort(tasks,(a,b)->a[0]-b[0]);
        int[] ans = new int[tasks.length];


        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comp());
        int ansIndex = 0;
        int index = 0;
        int time = 0;
        while(ansIndex<tasks.length){
            while(index < tasks.length && tasks[index][0]<=time){
                pq.offer(tasks[index++]);
            }

            if(pq.isEmpty()){
                time = tasks[index][0];
            }
            else{
                int[] top = pq.poll();
                time += top[1];
                ans[ansIndex++] = top[2];
            }

            
        }
        return ans;
    }
}

class Comp implements Comparator<int[]>{
    public int compare(int[]a,int[]b){
        if(a[1]!=b[1])
            return a[1] - b[1];
        else 
            return a[2] - b[2];
    }
}