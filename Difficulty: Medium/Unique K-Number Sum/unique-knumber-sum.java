import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), n, k, 1, 0);
        return result;
    }
    
    private void backtrack(ArrayList<ArrayList<Integer>> result, 
                           ArrayList<Integer> current, 
                           int target, int k, int start, int sum) {
        // If we already picked k numbers
        if (current.size() == k) {
            if (sum == target) {
                result.add(new ArrayList<>(current));
            }
            return;
        }
        
        // Try numbers from 'start' to 9
        for (int i = start; i <= 9; i++) {
            if (sum + i > target) break; // pruning
            current.add(i);
            backtrack(result, current, target, k, i + 1, sum + i);
            current.remove(current.size() - 1); // backtrack
        }
    }
}
