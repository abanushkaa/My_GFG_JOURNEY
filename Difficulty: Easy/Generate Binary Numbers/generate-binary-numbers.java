import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public ArrayList<String> generateBinary(int n) {
        ArrayList<String> result = new ArrayList<>(n);
        if (n <= 0) return result;

        Queue<String> q = new LinkedList<>();
        q.add("1");

        for (int i = 0; i < n; i++) {
            String s = q.poll();          // current binary
            result.add(s);                // add to result
            q.add(s + "0");               // append 0 -> next binary
            q.add(s + "1");               // append 1 -> next binary
        }

        return result;
    }
}
