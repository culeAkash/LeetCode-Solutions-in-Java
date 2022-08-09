public class Solution {
    public static int ceilingInSortedArray(int n, int x, int[] arr) {
        int start = 0,end  = n - 1;
        while(start<=end){
            int mid = start + (end - start)/2;
            
            if(arr[mid]==x)
                return arr[mid];
            else if(arr[mid]>x)
                end = mid - 1;
            else start = mid + 1;
        }
        return start==n?-1:arr[start];
    }
}