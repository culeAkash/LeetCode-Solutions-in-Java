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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return helper(root).lca;
    }

    private DeepestSubTreeReturn helper(TreeNode root){
        if(root==null)return new DeepestSubTreeReturn(0,null);

        DeepestSubTreeReturn leftSub = helper(root.left);
        DeepestSubTreeReturn rightSub = helper(root.right);

        if(leftSub.depth > rightSub.depth){
            return new DeepestSubTreeReturn(leftSub.depth+1,leftSub.lca);
        }else if(leftSub.depth < rightSub.depth){
            return new DeepestSubTreeReturn(rightSub.depth+1,rightSub.lca);
        }

        return new DeepestSubTreeReturn(rightSub.depth+1,root);
    }
}


class DeepestSubTreeReturn{
    int depth;
    TreeNode lca;

    public DeepestSubTreeReturn(int depth,TreeNode lca){
        this.depth = depth;
        this.lca = lca;
    }
}