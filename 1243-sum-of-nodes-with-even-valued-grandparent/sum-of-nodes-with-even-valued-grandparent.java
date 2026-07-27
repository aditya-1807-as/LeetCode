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
    int sum=0;
    public int sumEvenGrandparent(TreeNode root) {
        dfs(root,null,null);
        return sum;
    }
    private void dfs(TreeNode curr, TreeNode parent, TreeNode grand){
        if (curr==null){
            return;
        }

        if(grand!=null && grand.val%2==0){
            sum+=curr.val;
        }
        dfs(curr.left, curr, parent);
        dfs(curr.right, curr, parent);
    }
}