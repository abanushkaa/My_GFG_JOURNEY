import java.util.*;

class Solution {
    ArrayList<Integer> nthRowOfPascalTriangle(int n) {
        ArrayList<Integer> row = new ArrayList<>();

        long val = 1; // First value is always 1
        row.add(1);

        for (int r = 1; r < n; r++) {
            // Using formula: C(n-1, r) = C(n-1, r-1) * (n-r) / r
            val = val * (n - r) / r;
            row.add((int)val);
        }

        return row;
    }
}
