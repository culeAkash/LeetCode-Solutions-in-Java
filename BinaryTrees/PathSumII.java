 */
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        List<Integer> paths = new ArrayList<>();
        getAllPaths(paths,root,targetSum,0);
        return res;
    }
    
    void getAllPaths(List<Integer> paths,TreeNode root,int target,int sum){
        if(root==null)
            return;
        
        if(root.left==null && root.right==null){
            if(sum+root.val==target){
                System.out.println(paths);
                paths.add(root.val);
                res.add(new ArrayList<Integer>(paths));
                paths.remove(paths.size()-1);
            }
            return;
        }
    
        
        paths.add(root.val);
        System.out.println(paths);
        
        getAllPaths(paths,root.left,target,sum+root.val);
        getAllPaths(paths,root.right,target,sum+root.val);
        
        paths.remove(paths.size()-1);
    }
}