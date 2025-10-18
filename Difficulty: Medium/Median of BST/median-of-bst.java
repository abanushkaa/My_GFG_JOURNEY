class Solution {
    
    // Function to count total nodes in the BST
    private int countNodes(Node root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    // Helper function to find the median using inorder traversal
    private void inorderFind(Node root, int[] counter, int target, int[] median) {
        if (root == null || median[0] != -1) return; // stop early if median found
        
        inorderFind(root.left, counter, target, median);
        
        counter[0]++; // visiting a node
        if (counter[0] == target) {
            median[0] = root.data;
            return;
        }
        
        inorderFind(root.right, counter, target, median);
    }
    
    public int findMedian(Node root) {
        if (root == null) return 0;
        
        int total = countNodes(root);
        int target;
        
        // choose position based on even/odd rule from problem
        if (total % 2 == 0) target = total / 2;
        else target = (total + 1) / 2;
        
        int[] counter = {0};
        int[] median = {-1};
        
        inorderFind(root, counter, target, median);
        return median[0];
    }
}
