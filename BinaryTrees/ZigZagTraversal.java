/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> s1= new Stack<>();
        Stack<TreeNode> s2= new Stack<>();
        List<List<Integer>> ans= new ArrayList<>();
        if(root==null){
            return ans;
        }
        s1.push(root);
        while(!s1.isEmpty() || !s2.isEmpty()){
            List<Integer> l1=new ArrayList<>();
            while(!s1.isEmpty()){
                TreeNode temp= s1.pop();
                l1.add(temp.val);
                
                if(temp.left!=null){
                    s2.push(temp.left);
                }
                if(temp.right!=null){
                    s2.push(temp.right);
                }
            }
            if(l1.size()>0)
            ans.add(l1);
            
            List<Integer> l2=new ArrayList<>();
            while(!s2.isEmpty()){
                TreeNode temp= s2.pop();
                l2.add(temp.val);
                
                if(temp.right!=null){
                    s1.push(temp.right);
                }
                if(temp.left!=null){
                    s1.push(temp.left);
                }
            }
            if(l2.size()>0)
            ans.add(l2);
        }
        return ans;
    }
}
