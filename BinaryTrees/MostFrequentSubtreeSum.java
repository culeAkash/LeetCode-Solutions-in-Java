class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer,Integer> map = new HashMap<>();
        
        helper(root,map);
        
        int max = Integer.MIN_VALUE;
        
        for(int val : map.values())
            max = Math.max(max,val);
        
        List<Integer> res = new ArrayList<>();
        for(int key: map.keySet()){
            if(map.get(key)==max)
                res.add(key);
        }
        
        int[] ans = new int[res.size()];
        for(int i=0;i<ans.length;i++)
            ans[i] = res.get(i);
        
        return ans;
        
        
    }
    
    int helper(TreeNode root,Map<Integer,Integer> map){
        if(root==null)
            return 0;
        
        if(root.left==null && root.right==null){
            map.put(root.val,map.getOrDefault(root.val,0)+1);
            return root.val;
        }
        
        int sum =  root.val;
        
        sum += helper(root.left,map);
        sum += helper(root.right,map);
        
        map.put(sum,map.getOrDefault(sum,0)+1);
        return sum;
    }
}