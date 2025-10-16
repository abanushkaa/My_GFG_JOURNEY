class Solution {
    Node removekeys(Node root, int l, int r) {
        // Base case
        if (root == null)
            return null;

        // Recur for left and right subtrees
        root.left = removekeys(root.left, l, r);
        root.right = removekeys(root.right, l, r);

        // If current node is smaller than l, discard left subtree
        if (root.data < l)
            return root.right;

        // If current node is greater than r, discard right subtree
        if (root.data > r)
            return root.left;

        // Node is within range
        return root;
    }
}
