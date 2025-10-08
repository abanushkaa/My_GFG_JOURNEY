/*
class Node {
    int data;
    Node left, right;
    Node(int val){
        data = val;
        left = right = null;
    }
}
*/

import java.util.*;

class Solution {
    public ArrayList<Integer> postOrder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        postOrderTraversal(root, result);
        return result;
    }
    
    private void postOrderTraversal(Node node, ArrayList<Integer> result) {
        if (node == null) return;
        
        // 1. Visit left subtree
        postOrderTraversal(node.left, result);
        
        // 2. Visit right subtree
        postOrderTraversal(node.right, result);
        
        // 3. Visit root
        result.add(node.data);
    }
}
