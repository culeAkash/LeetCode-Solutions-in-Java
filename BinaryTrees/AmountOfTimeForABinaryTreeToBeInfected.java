class Solution {
    TreeNode node = null;
    
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode,TreeNode> map = new HashMap<>();
        
        findNode(root,start,map,null);
        
        
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(node);
        

        int count = countTime(node,map,queue);
        return count;
        
    }
    
    public int countTime(TreeNode root,Map<TreeNode,TreeNode> map,Queue<TreeNode> q){
        
        int count = 0;
        root.val=0;
        
        while(!q.isEmpty()){
            
            int size = q.size();
            
            while(size>0){
            TreeNode top = q.poll();
            
            if(top.left!=null && top.left.val!=0){
                q.add(top.left);
                top.left.val = 0;
            }
              
            if(top.right!=null && top.right.val!=0){
                q.add(top.right);
                top.right.val = 0;
            }
                
            if(map.get(top)!=null && map.get(top).val!=0){
                q.add(map.get(top));
                map.get(top).val = 0;
            }
                size--;
            }
            
            if(q.size()!=0)
                count++;
        }
        
        return count;
        
    }
    
    public void findNode(TreeNode root,int val,Map<TreeNode,TreeNode> map,TreeNode parent){
        if(root==null)
            return;
        
        if(root.val==val)
            node = root;
        
        map.put(root,parent);
        
        findNode(root.left,val,map,root);
        findNode(root.right,val,map,root);
        
    }
    
    
}