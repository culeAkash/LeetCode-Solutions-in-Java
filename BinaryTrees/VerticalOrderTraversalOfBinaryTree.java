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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,LinkedList<Integer>>> map= new TreeMap<>();
        List<List<Integer>> ans= new ArrayList<>();
        if(root==null){
            return ans;
        }
        Queue<Triplet> q= new LinkedList<>();
        
        q.add(new Triplet(root,0,0));
        while(!q.isEmpty()){
            int size= q.size();
            for(int i=0;i<size;i++){
                Triplet temp= q.poll();
                if(!map.containsKey(temp.vertical)){
                    map.put(temp.vertical,new TreeMap<>());
                }
                if(!map.get(temp.vertical).containsKey(temp.level)){
                    map.get(temp.vertical).put(temp.level,new LinkedList<>());
                }
                map.get(temp.vertical).get(temp.level).add(temp.node.val);
                
                if(temp.node.left!=null){
                    q.add(new Triplet(temp.node.left,temp.vertical-1,temp.level+1));
                }
                if(temp.node.right!=null){
                    q.add(new Triplet(temp.node.right,temp.vertical+1,temp.level+1));
                }
            }
        }
        for(TreeMap<Integer,LinkedList<Integer>> it:map.values()){
            ans.add(new ArrayList<>());
            for(LinkedList<Integer> l:it.values()){
                Collections.sort(l);
                for(Integer i:l){
                    ans.get(ans.size()-1).add(i);
                }
            }
        }
        return ans;
    }
}

class Triplet{
    TreeNode node;
    int vertical;
    int level;
    
    Triplet(TreeNode n,int v,int l){
        node=n;
        vertical=v;
        level=l;
    }
}