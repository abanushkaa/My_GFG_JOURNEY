/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

import java.util.*;

class Solution {
    int preIndex = 0;

    public Node constructTree(int[] pre, int[] post) {
        int n = pre.length;
        Map<Integer, Integer> postIndex = new HashMap<>();

        // Store index of each node in postorder for O(1) lookup
        for (int i = 0; i < n; i++) {
            postIndex.put(post[i], i);
        }

        return build(pre, post, postIndex, 0, n - 1);
    }

    private Node build(int[] pre, int[] post, Map<Integer, Integer> postIndex, int l, int r) {
        if (preIndex >= pre.length || l > r)
            return null;

        // The first element in preorder is always the root
        Node root = new Node(pre[preIndex++]);

        // Base case: single node (leaf)
        if (l == r || preIndex >= pre.length)
            return root;

        // Find index of next preorder element in postorder
        int nextVal = pre[preIndex];
        int idx = postIndex.get(nextVal);

        // Build left and right subtrees
        root.left = build(pre, post, postIndex, l, idx);
        root.right = build(pre, post, postIndex, idx + 1, r - 1);

        return root;
    }
}
