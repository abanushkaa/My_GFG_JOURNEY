import java.util.*;

class Solution {
    public ArrayList<String> binstr(int n) {
        ArrayList<String> result = new ArrayList<>();
        int total = 1 << n; // 2^n
        
        for (int i = 0; i < total; i++) {
            String binary = Integer.toBinaryString(i);
            // pad with leading zeros
            while (binary.length() < n) {
                binary = "0" + binary;
            }
            result.add(binary);
        }
        
        return result;
    }
}
