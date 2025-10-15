/* 
class Node {
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

import java.util.Stack;

class Solution {
    public int kthSmallest(Node root, int k) {
        if (root == null || k <= 0) return -1;
        
        Stack<Node> st = new Stack<>();
        Node cur = root;
        
        while (cur != null || !st.isEmpty()) {
            // go to leftmost node
            while (cur != null) {
                st.push(cur);
                cur = cur.left;
            }
            
            cur = st.pop();
            k--; // visited one node (in-order)
            if (k == 0) return cur.data;
            
            cur = cur.right; // continue with right subtree
        }
        
        // k was larger than number of nodes
        return -1;
    }
}
