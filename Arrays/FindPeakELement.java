class Solution {
    public int findPeakElement(int[] arr) {
        int n = arr.length;
        
        if(n==1)
            return 0;
            
        int start = 0, end = n -1;
        
        while(start<=end){
            int mid = start + (end - start)/2;
            
            if(mid>0 && mid<n-1){
                if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1])
                    return mid;
                else if(arr[mid]<arr[mid-1])
                    end = mid - 1;
                else 
                    start = mid + 1;
            }
            else if(mid==0){
                if(arr[mid]>arr[mid+1])
                    return 0;
                else
                    return 1;
            }
            else{
                if(arr[mid]>arr[mid-1])
                    return n-1;
                else return n - 2;
            }
        }
        return -1;
    }
}