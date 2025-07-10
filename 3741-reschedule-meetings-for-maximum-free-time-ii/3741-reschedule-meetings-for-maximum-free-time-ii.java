class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        List<Integer> freeTimes = new ArrayList<>();
        int lastEnd = 0;
        for(int i=0;i<startTime.length;i++){
            freeTimes.add(startTime[i] - lastEnd);
            lastEnd = endTime[i];
        }
        freeTimes.add(eventTime - lastEnd);

        List<Integer> maxSuffix = new ArrayList<>();
        int maxi = -1;
        for(int i=freeTimes.size()-1;i>0;i--){
            maxSuffix.add(0,maxi);
            maxi = Math.max(maxi,freeTimes.get(i));
        }

        int maxPrefix = -1;
        int res = 0;
        for(int i=0;i<freeTimes.size()-1;i++){
            int firstFree = freeTimes.get(i);
            int secondFree = freeTimes.get(i+1);

            int temp1 = firstFree + secondFree;
            int dur = endTime[i] - startTime[i];
            res = Math.max(res,temp1);
            if(maxPrefix >= dur || maxSuffix.get(i) >= dur){
                res = Math.max(res,temp1 + dur);
            }

            maxPrefix = Math.max(maxPrefix,freeTimes.get(i));
        }

        return res;
    }
}