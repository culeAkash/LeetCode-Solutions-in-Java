class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int lastEndTime = 0;
        int emp = 0;
        
        int maxTime = 0;
        
        for(int[] log : logs){
            int time = log[1] - lastEndTime;
            System.out.println(time + " "+maxTime + " "+ emp);
            if(time>maxTime){
                emp = log[0];
                maxTime = time;
            }
            else if(time==maxTime){
                emp = Math.min(emp,log[0]);
            }
            
            lastEndTime = log[1];
        }
        return emp;
    }
}