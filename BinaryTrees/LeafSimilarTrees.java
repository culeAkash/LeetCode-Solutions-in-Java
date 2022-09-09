class Solution {
    List<Integer> l1 = new ArrayList<>();
    List<Integer> l2 = new ArrayList<>();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
        
        helper(root1,l1);
        System.out.println(l1);
        helper(root2,l2);
        System.out.println(l2);
        
        if(l1.size()!=l2.size())
            return false;
        
        for(int i=0;i<l1.size();i++){
                if(l1.get(i)!=l2.get(i))
                    return false;
            }
        return true;
    }
    
    void helper(TreeNode root,List<Integer> list){
        if(root==null)
            return;
        if(root.left==null && root.right==null){
            list.add(root.val);
            return;
            }
        
        helper(root.left,list);
        
        helper(root.right,list);
        
    }
}