// User function Template for Java

class Solution {
    static int palPartition(String s) {
        int n = s.length();
        boolean[][] isPal = new boolean[n][n];
        
        // Step 1: Precompute palindrome substrings
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (len <= 2) {
                        isPal[i][j] = true;
                    } else {
                        isPal[i][j] = isPal[i+1][j-1];
                    }
                }
            }
        }
        
        // Step 2: DP for minimum cuts
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (isPal[0][i]) {
                dp[i] = 0; // whole substring is palindrome, no cuts
            } else {
                dp[i] = i; // worst case: cut between every char
                for (int j = 1; j <= i; j++) {
                    if (isPal[j][i]) {
                        dp[i] = Math.min(dp[i], dp[j-1] + 1);
                    }
                }
            }
        }
        
        return dp[n-1];
    }
}
