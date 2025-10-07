import java.util.*;

class Solution {
    // Node class given
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        // Map to store (horizontalDistance -> nodeValue)
        Map<Integer, Integer> map = new TreeMap<>();

        // Queue for BFS: store pairs of (node, horizontalDistance)
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            Node node = curr.node;
            int hd = curr.hd;

            // Update map with the latest node for this HD
            map.put(hd, node.data);

            // Traverse children with updated HDs
            if (node.left != null) q.add(new Pair(node.left, hd - 1));
            if (node.right != null) q.add(new Pair(node.right, hd + 1));
        }

        // Collect values in order of HD (sorted by TreeMap)
        for (int val : map.values()) {
            result.add(val);
        }

        return result;
    }

    // Helper class to store node + its horizontal distance
    class Pair {
        Node node;
        int hd;

        Pair(Node n, int h) {
            node = n;
            hd = h;
        }
    }
}
