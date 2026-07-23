class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int maxSoFar) {
        if (node == null) {
            return 0;
        }

        int count = 0;

        // Current node is good
        if (node.val >= maxSoFar) {
            count = 1;
        }

        // Update maximum value in current path
        maxSoFar = Math.max(maxSoFar, node.val);

        // Count good nodes in left and right subtree
        count += dfs(node.left, maxSoFar);
        count += dfs(node.right, maxSoFar);

        return count;
    }
}