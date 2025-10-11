class Solution {
    int moves = 0;  // Global counter for total moves

    public int distCandy(Node root) {
        dfs(root);
        return moves;
    }

    private int dfs(Node root) {
        if (root == null)
            return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        // Accumulate the total moves from both children
        moves += Math.abs(left) + Math.abs(right);

        // Return the excess candies at this node
        return root.data + left + right - 1;
    }
}
