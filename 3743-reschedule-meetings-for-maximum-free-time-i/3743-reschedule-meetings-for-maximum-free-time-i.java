class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {

        List<Integer> freeTimes = new ArrayList<>();
        int nextEnd = 0;
        for(int i=0;i<startTime.length;i++){
            freeTimes.add(startTime[i] - nextEnd);
            nextEnd = endTime[i];
        }

        freeTimes.add(eventTime - nextEnd);
        int res = 0;
        int runningSum = 0;
        for(int i=0;i<=k;i++){
            runningSum += freeTimes.get(i);
        }
        res = runningSum;

        for(int i=k+1;i<freeTimes.size();i++){
            // System.out.print(res + " ");
            runningSum = runningSum - freeTimes.get(i - k - 1) + freeTimes.get(i);
            // System.out.println(runningSum);
            res = Math.max(res,runningSum);
        }


        return res;

    }
}