class Solution {

    public int[] arrayRankTransform(int[] arr) {
        Map<Integer,Integer> numToRank = new HashMap<>();

        TreeSet<Integer> nums = new TreeSet<>();

        for(int num : arr) nums.add(num);
        int rank = 1;

        for(int num : nums){
            numToRank.put(num,rank);
            rank++;
        }

        for(int i=0;i<arr.length;i++){
            arr[i] = numToRank.get(arr[i]);
        }

        return arr;
    }
}