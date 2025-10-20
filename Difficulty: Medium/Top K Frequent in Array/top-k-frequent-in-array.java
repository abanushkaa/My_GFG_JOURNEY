import java.util.*;

class Solution {
    public ArrayList<Integer> topKFreq(int[] arr, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        
        // Step 1: Count frequencies
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Create a priority queue (max heap)
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (b[1] == a[1]) return b[0] - a[0]; // if same freq, larger number first
                return b[1] - a[1]; // higher freq first
            }
        );

        // Step 3: Push all entries into heap
        for (Map.Entry<Integer, Integer> e : freq.entrySet()) {
            pq.offer(new int[]{e.getKey(), e.getValue()});
        }

        // Step 4: Extract top k elements
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            result.add(pq.poll()[0]);
        }

        return result;
    }
}
