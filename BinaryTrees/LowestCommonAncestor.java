class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> path1= new ArrayList<>();
        ArrayList<TreeNode> path2= new ArrayList<>();
        helper(path1,root,p);
        helper(path2,root,q);
        
        int i;
        for(i=0;i<path1.size() && i<path2.size();i++){
            if(path1.get(i)!=path2.get(i)){
                break;
            }
        }
        return path1.get(i-1);
        
        
        
    }
    
    public boolean helper(ArrayList<TreeNode> ans,TreeNode root,TreeNode target){
        if(root==null){
            return false;
        }

        ans.add(root);//we put to the ans gambling and if really present it will get returend in next conditions
        if(root==target){
            // ans.add(0,root.val);
            return true;
        }

        if(helper(ans,root.left,target) || helper(ans,root.right,target)){
            // ans.add(0,root.val);
            return true;
        }

        //If the flow reaches here then the node is not definitely in the path so we remove it
        ans.remove(ans.size()-1);
        return false;
    }
}