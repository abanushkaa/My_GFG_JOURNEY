import java.util.*;

class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        int n = arr.length;
        
        // To store the final answer (span for each day)
        ArrayList<Integer> result = new ArrayList<>(n); 
        
        // Stack to store indices of days
        // We use indices instead of prices so that
        // we can calculate the span directly using positions
        Stack<Integer> st = new Stack<>();

        // Traverse all days
        for (int i = 0; i < n; i++) {
            
            // Step 1: Pop all previous days whose price <= today's price
            // Why? Because today's price "dominates" those days,
            // and their span is already included in today's span.
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            
            // Step 2: If stack is empty, it means there is no greater element on the left
            // So the span = i + 1 (all days from 0 to i are smaller/equal)
            if (st.isEmpty()) {
                result.add(i + 1);
            } 
            // Otherwise, the top of the stack is the index of
            // the previous greater element. So span = (i - st.peek()).
            else {
                result.add(i - st.peek());
            }
            
            // Step 3: Push current index into stack
            st.push(i);
        }

        return result;
    }
}
