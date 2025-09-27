class Solution {
    public int kBitFlips(int[] arr, int k) {
        int n = arr.length;
        int[] flipped = new int[n]; // marks where flips start
        int flipParity = 0; // 0 = even flips, 1 = odd flips
        int flips = 0;

        for (int i = 0; i < n; i++) {
            // Remove effect of flip that ended here
            if (i >= k) {
                flipParity ^= flipped[i - k];
            }

            // Effective value at arr[i]
            int val = arr[i] ^ flipParity;

            // If it's 0, we must flip here
            if (val == 0) {
                if (i + k > n) return -1; // not enough space
                flips++;
                flipParity ^= 1;  // start new flip
                flipped[i] = 1;   // mark flip started here
            }
        }
        return flips;
    }
}

