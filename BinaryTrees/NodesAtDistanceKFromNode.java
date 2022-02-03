/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans= new ArrayList<>();
        if(root==null){
            return ans;
        }
        Map<TreeNode,TreeNode> parent= new HashMap<>();
        getParentTrack(root,parent);
        Map<TreeNode,Boolean> visited= new HashMap<>();
        Queue<TreeNode> q= new LinkedList<>();
        q.add(target);
        visited.put(target,true);
        int level=0;
        while(!q.isEmpty()){
            int size= q.size();
            if(level==k)
                break;
            level++;
            
            for(int i=1;i<=size;i++){
                TreeNode node= q.poll();
                
                if(parent.get(node)!=null && visited.get(parent.get(node))==null){
                    visited.put(parent.get(node),true);
                    q.add(parent.get(node));
                }
                
                if(node.left!=null && visited.get(node.left)==null){
                    visited.put(node.left,true);
                    q.add(node.left);
                }
                
                if(node.right!=null && visited.get(node.right)==null){
                    visited.put(node.right,true);
                    q.add(node.right);
                }
            }
        }
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;
        
    }
    
    public void getParentTrack(TreeNode root,Map<TreeNode,TreeNode> parent){
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        parent.put(root,null);
        while(!q.isEmpty()){
            TreeNode node= q.poll();
            if(node.left!=null){
                parent.put(node.left,node);
                q.add(node.left);
            }
            if(node.right!=null){
                parent.put(node.right,node);
                q.add(node.right);
            }
        }
    }
}