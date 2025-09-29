import java.util.*;

class Solution {
    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        int n = arr.length;
        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();
        
        int left = 0, bestStart = 0, bestLen = 0;
        
        for (int right = 0; right < n; right++) {
            // Maintain decreasing deque for max
            while (!maxDeque.isEmpty() && arr[maxDeque.peekLast()] < arr[right]) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(right);
            
            // Maintain increasing deque for min
            while (!minDeque.isEmpty() && arr[minDeque.peekLast()] > arr[right]) {
                minDeque.pollLast();
            }
            minDeque.addLast(right);
            
            // Shrink window if condition fails
            while (!maxDeque.isEmpty() && !minDeque.isEmpty() 
                   && arr[maxDeque.peekFirst()] - arr[minDeque.peekFirst()] > x) {
                if (maxDeque.peekFirst() == left) maxDeque.pollFirst();
                if (minDeque.peekFirst() == left) minDeque.pollFirst();
                left++;
            }
            
            // Update best window
            if (right - left + 1 > bestLen) {
                bestLen = right - left + 1;
                bestStart = left;
            }
        }
        
        // Build result
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = bestStart; i < bestStart + bestLen; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}
