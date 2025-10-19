import java.util.*;

class Solution {
    public ArrayList<Integer> getKClosest(Node root, int target, int k) {
        ArrayList<Integer> inorderList = new ArrayList<>();
        inorderTraversal(root, inorderList);

        // Sort by (absolute difference, then by value)
        inorderList.sort((a, b) -> {
            int diff1 = Math.abs(a - target);
            int diff2 = Math.abs(b - target);
            if (diff1 == diff2) return a - b;
            return diff1 - diff2;
        });

        // Pick first k elements
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < k && i < inorderList.size(); i++) {
            result.add(inorderList.get(i));
        }

        return result;
    }

    private void inorderTraversal(Node root, ArrayList<Integer> list) {
        if (root == null) return;
        inorderTraversal(root.left, list);
        list.add(root.data);
        inorderTraversal(root.right, list);
    }
}
