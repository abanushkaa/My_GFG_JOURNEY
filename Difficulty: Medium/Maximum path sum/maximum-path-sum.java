class Solution {
    int maxSum;

    int findMaxSum(Node root) {
        maxSum = Integer.MIN_VALUE;
        helper(root);
        return maxSum;
    }

    int helper(Node node) {
        if (node == null) return 0;

        // Recurse for left and right subtrees
        int left = Math.max(0, helper(node.left));   // ignore negatives
        int right = Math.max(0, helper(node.right)); // ignore negatives

        // Max path sum passing through this node
        int currPathSum = node.data + left + right;

        // Update global max if needed
        maxSum = Math.max(maxSum, currPathSum);

        // Return max downward path (one side only)
        return node.data + Math.max(left, right);
    }
}
