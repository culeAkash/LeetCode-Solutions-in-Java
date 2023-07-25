class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length-1;

        if(arr[start]>arr[start+1])
            return 0;

        if(arr[end]>arr[end-1])
            return end;

        while(start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid]<arr[mid+1]){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return end+1;
    }
}