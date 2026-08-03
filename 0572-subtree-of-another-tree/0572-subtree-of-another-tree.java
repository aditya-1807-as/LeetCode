class Solution {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        // If main tree is empty
        if (root == null)
            return false;

        // Check if current subtree matches
        if (isSameTree(root, subRoot))
            return true;

        // Otherwise search left and right
        return isSubtree(root.left, subRoot) ||
               isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode p, TreeNode q) {

        // Both null
        if (p == null && q == null)
            return true;

        // One null
        if (p == null || q == null)
            return false;

        // Different values
        if (p.val != q.val)
            return false;

        // Compare children
        return isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }
}