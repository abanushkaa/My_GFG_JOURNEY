import java.util.*;

class Solution {
    public void nearlySorted(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int n = arr.length;
        int index = 0;

        // Step 1: Push first k+1 elements into min heap
        for (int i = 0; i < Math.min(n, k + 1); i++) {
            minHeap.add(arr[i]);
        }

        // Step 2: For the remaining elements
        for (int i = k + 1; i < n; i++) {
            arr[index++] = minHeap.poll();  // smallest element to correct position
            minHeap.add(arr[i]);            // add next element
        }

        // Step 3: Empty the remaining heap
        while (!minHeap.isEmpty()) {
            arr[index++] = minHeap.poll();
        }
    }
}
