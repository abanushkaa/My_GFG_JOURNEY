/*
class Node {
    int data;
    Node left, right;

    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
*/

class Solution {

    // Helper class to store include and exclude values
    static class Pair {
        int include; // sum including this node
        int exclude; // sum excluding this node

        Pair(int include, int exclude) {
            this.include = include;
            this.exclude = exclude;
        }
    }

    public int getMaxSum(Node root) {
        Pair result = solve(root);
        return Math.max(result.include, result.exclude);
    }

    private Pair solve(Node root) {
        if (root == null)
            return new Pair(0, 0);

        Pair left = solve(root.left);
        Pair right = solve(root.right);

        // If we include current node, we cannot include its children
        int include = root.data + left.exclude + right.exclude;

        // If we exclude current node, we can include or exclude its children
        int exclude = Math.max(left.include, left.exclude) + Math.max(right.include, right.exclude);

        return new Pair(include, exclude);
    }
}
