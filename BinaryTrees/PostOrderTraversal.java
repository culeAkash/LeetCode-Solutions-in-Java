//Recursive Solution

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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans= new ArrayList<Integer>();
        helper(root,ans);
        return ans;
    }
    
    public void helper(TreeNode root,List<Integer> ans){
        if(root==null){
            return;
        }
        helper(root.left,ans);
        helper(root.right,ans);
        ans.add(root.val);
    }
}

//Iterative Solution

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans= new ArrayList<Integer>();
        helper(root,ans);
        return ans;
    }
    
    public void helper(TreeNode root,List<Integer> ans){
        if(root==null){
            return;
        }
        Stack<TreeNode> s1= new Stack<>();
        Stack<TreeNode> s2= new Stack<>();
        s1.push(root);
        while(!s1.isEmpty()){
            root=s1.pop();
            s2.push(root);
            
            if(root.left!=null){
                s1.push(root.left);
            }
            if(root.right!=null){
                s1.push(root.right);
            }
        }
        while(!s2.isEmpty()){
            ans.add(s2.pop().val);
        }
    }
}
