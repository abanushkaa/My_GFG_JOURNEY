import java.util.*;

class Solution {
    public ArrayList<Integer> countBSTs(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();

        // Sort a copy to get BST ordering
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        // Precompute number of BSTs for up to 6 nodes (Catalan numbers)
        int[] numBST = new int[n + 1];
        numBST[0] = 1;
        for (int i = 1; i <= n; i++) {
            numBST[i] = 0;
            for (int j = 0; j < i; j++) {
                numBST[i] += numBST[j] * numBST[i - j - 1];
            }
        }

        // For each element in original array
        for (int val : arr) {
            // Find index in sorted array
            int index = Arrays.binarySearch(sorted, val);
            int left = index;            // nodes smaller than root
            int right = n - index - 1;   // nodes greater than root
            int count = numBST[left] * numBST[right];
            result.add(count);
        }

        return result;
    }
}
