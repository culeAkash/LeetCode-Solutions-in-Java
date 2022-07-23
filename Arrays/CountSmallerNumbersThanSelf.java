// class Solution {
//     public List<Integer> countSmaller(int[] nums) {
//         if(nums == null) return null;
        
//         Integer countArr[] = new Integer[nums.length];
//         if(nums.length == 0) return new ArrayList<>();
        
//         for(int i = nums.length - 1; i >= 0; i--){
//             int count = insertAndReturnCount(nums[i]);
//             countArr[i] = count;
//         }
        
//         return Arrays.asList(countArr);
//     }
    
//     private Node root;// Root of the BST - Binary Search Tree
    
//     public int insertAndReturnCount(int val){
//         if(root == null){
//             root = new Node(val);
//             return 0;
//         }
        
//         int count = 0;
//         Node curr = root;
//         while(true){
//             // decide where to go, and increase count
            
//             if(val >= curr.val){
//                 if(val > curr.val)
//                     count++; // for curr node (since val is greater than curr.val)
                
//                 // go to left
//                 count += curr.rightCount;
//                 curr.leftCount++;
                
//                 if(curr.left == null){
//                     curr.left = new Node(val);
//                     break;
//                 }
//                 else 
//                     curr = curr.left;
//             }
//             else {
//                 // go to right, don't increase count
//                 curr.rightCount++;
                
//                 if(curr.right == null){
//                     curr.right = new Node(val);
//                     break;
//                 }
//                 else 
//                     curr = curr.right;
//             }
//         }
        
//         return count;
//     }
    
//     public static class Node {
//         int leftCount;
//         int rightCount;
//         int val;
//         Node left;
//         Node right;
        
//         Node(final int val){
//             this.val = val;
//         }
//     }
// }

class Solution {    
    public List<Integer> countSmaller(int[] nums) {
        int min = 20001;
        int max = -1;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        min--;
        int[] count = new int[max-min+1];
        Integer[] result = new Integer[nums.length];
        for (int i = nums.length-1; i >=0; i--) {
            int k = nums[i]-min-1;
            int c = 0;
            do {
                c += count[k];
                k -= (-k&k);
            } while (k > 0);
            result[i] = c;
            
            k = nums[i]-min;
            while (k < count.length) {
                count[k]++;
                k += (-k&k);
            }
        }
        
        return Arrays.asList(result);
    }
}