import java.util.*;

class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>(n); // pre-size
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                result.add(i + 1);
            } else {
                result.add(i - st.peek());
            }
            st.push(i);
        }

        return result;
    }
}
