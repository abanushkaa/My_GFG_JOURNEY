import java.util.*;

class Solution {
    public static void rotateDeque(Deque<Integer> dq, int type, int k) {
        int n = dq.size();
        if (n == 0) return; 
        
        k = k % n;  // reduce unnecessary rotations
        if (k == 0) return;
        
        if (type == 1) {  // Right Rotation
            for (int i = 0; i < k; i++) {
                int val = dq.pollLast();
                dq.offerFirst(val);
            }
        } else if (type == 2) {  // Left Rotation
            for (int i = 0; i < k; i++) {
                int val = dq.pollFirst();
                dq.offerLast(val);
            }
        }
    }
}
