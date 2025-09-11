

// User function Template for Java

class Solution {
    boolean twoSum(int arr[], int target) {
        // code here
        HashSet<Integer> set = new HashSet<>();
        for(int num: arr){
            int needed= target-num;
            if (set.contains(needed)) {
                return true; // Pair found
            }
            set.add(num);
            
        }
       return false;
    }
  
}