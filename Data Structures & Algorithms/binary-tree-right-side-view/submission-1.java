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
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<Integer> rightView = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int levelBreadth = 0;
        while(!queue.isEmpty()) {
            levelBreadth = queue.size();
            while(levelBreadth>1) {
                TreeNode nodeElem = queue.remove();
                processChilds(nodeElem, queue);
                levelBreadth--;
            }
            //last elem of level
            TreeNode lastNodeElem = queue.remove();
            processChilds(lastNodeElem, queue);
            rightView.add(lastNodeElem.val);
        }

        return rightView;
        
    }

    void processChilds(TreeNode nodeElem, Queue<TreeNode> queue){
        if(nodeElem.left!=null){
            queue.add(nodeElem.left);
        }
        if(nodeElem.right!=null){
            queue.add(nodeElem.right);
        }
    }
}
