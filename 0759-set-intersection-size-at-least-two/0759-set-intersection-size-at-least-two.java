class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[1]==b[1] ? b[0] - a[0] : a[1] - b[1]);

        List<Integer> nums = new ArrayList<>();
        int ans = 0;

        for(int[] interval : intervals){

            int start = interval[0],end = interval[1];
            int count = 0;
            for(int index = nums.size() - 1;index>=0;index--){
                if(nums.get(index)>=start && nums.get(index)<=end){
                    count++;
                    if(count==2)break;
                }
            }

            if(count==0){
                ans += 2;
                nums.add(end);
                nums.add(end-1);
            }else if(count==1){
                ans += 1;
                nums.add(end);
            }
        }

        return ans;
    }


}