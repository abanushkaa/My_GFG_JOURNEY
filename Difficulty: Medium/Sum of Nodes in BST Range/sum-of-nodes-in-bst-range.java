class Solution {
    public int nodeSum(Node root, int l, int r) {
        // Base case
        if (root == null)
            return 0;

        // If root's value is less than l, ignore left subtree
        if (root.data < l)
            return nodeSum(root.right, l, r);

        // If root's value is greater than r, ignore right subtree
        if (root.data > r)
            return nodeSum(root.left, l, r);

        // If root's value lies in the range [l, r], include it and check both subtrees
        return root.data + nodeSum(root.left, l, r) + nodeSum(root.right, l, r);
    }
}
