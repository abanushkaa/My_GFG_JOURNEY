import java.util.*;

class Solution {
    ArrayList<Integer> zigZagTraversal(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true; // flag to alternate direction

        while (!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                Node node = queue.poll();

                // insert according to direction
                if (leftToRight) level.addLast(node.data);
                else level.addFirst(node.data);

                // enqueue children
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            result.addAll(level);
            leftToRight = !leftToRight; // toggle direction
        }

        return result;
    }
}
