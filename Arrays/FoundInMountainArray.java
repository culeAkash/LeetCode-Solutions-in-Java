class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int start = 0;
        int end = mountainArr.length() - 1;

       int peakIndex = findPeakIndex(mountainArr,start,end);


       int ans = findElement(mountainArr,start,peakIndex,true,target);

       if(ans!=-1)
        return ans;
    
        return findElement(mountainArr,peakIndex,end,false,target);
    }


    public int findElement(MountainArray arr,int start,int end,boolean isAsc,int target){
        while(start<=end){
            int mid = start + (end-start)/2;
            if(isAsc){
                if(arr.get(mid)==target)
                    return mid;
                if(arr.get(mid)>target)
                    end = mid - 1;
                else
                    start = mid + 1;
            }
            else{
                if(arr.get(mid)==target)
                    return mid;
                if(arr.get(mid)>target)
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }


    public int findPeakIndex(MountainArray arr,int start,int end){
        
        while(start<end){
            int mid = start + (end-start)/2;

            if(arr.get(mid)>arr.get(mid+1))
                end = mid;
            else{
                start = mid + 1;
            }
        }

        return start;
    }
}