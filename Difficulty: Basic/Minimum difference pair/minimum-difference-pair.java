// User function Template for Java

class Solution {
    public int minimumDifference(int[] arr) {
        // code here
        Arrays.sort(arr); // Step 1: Sort the array

        int minDiff = Integer.MAX_VALUE;

        // Step 2: Check adjacent elements only
        for (int i = 1; i < arr.length; i++) {
 
            int diff = arr[i] - arr[i - 1];
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }
    
}