import java.util.*;
public class Solution {

	public static int longestIncreasingSubsequence(int arr[]) {
		int n = arr.length;
		ArrayList<Integer> list = new ArrayList<>();
		list.add(arr[0]);
		for(int i=1;i<n;i++){
			int index = lowerBound(list,arr[i]);
			if(index>=list.size())
				list.add(arr[i]);
			else
				list.set(index,arr[i]);
		}
		return list.size();
	}
	private static int lowerBound(ArrayList<Integer> list,int val){
		int low=0,high=list.size()-1;
		while(low<high){
			int mid = low + (high-low)/2;
			if(list.get(mid)>=val)
				high=mid;
			else
				low=mid+1;
		}
		
		if(low<list.size() && list.get(low)<val)
			low++;
		return low;
	}

}