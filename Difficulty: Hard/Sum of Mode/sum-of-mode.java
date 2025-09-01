import java.util.*;

class Solution {
    public int sumOfModes(int[] arr, int k) {
        int n = arr.length;
        if (k > n) return 0;

        Map<Integer, Integer> freq = new HashMap<>();
        TreeMap<Integer, TreeSet<Integer>> freqMap = new TreeMap<>();
        int sum = 0;

        // Helper to add number
        Runnable add = () -> {};
        
        for (int i = 0; i < n; i++) {
            // add arr[i]
            int oldFreq = freq.getOrDefault(arr[i], 0);
            if (oldFreq > 0) {
                freqMap.get(oldFreq).remove(arr[i]);
                if (freqMap.get(oldFreq).isEmpty()) freqMap.remove(oldFreq);
            }
            int newFreq = oldFreq + 1;
            freq.put(arr[i], newFreq);
            freqMap.computeIfAbsent(newFreq, x -> new TreeSet<>()).add(arr[i]);

            // remove arr[i-k] when window exceeds size k
            if (i >= k) {
                int rem = arr[i - k];
                int f = freq.get(rem);
                freqMap.get(f).remove(rem);
                if (freqMap.get(f).isEmpty()) freqMap.remove(f);
                if (f == 1) freq.remove(rem);
                else {
                    freq.put(rem, f - 1);
                    freqMap.computeIfAbsent(f - 1, x -> new TreeSet<>()).add(rem);
                }
            }

            // if window size = k, record mode
            if (i >= k - 1) {
                int maxFreq = freqMap.lastKey();
                int mode = freqMap.get(maxFreq).first(); // smallest element with max freq
                sum += mode;
            }
        }

        return sum;
    }
}
