

class Solution {
    void printTriangle(int n) {
        for(int i = 0; i < n; i++) {
            // Print leading spaces
            for(int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }

            // Printing characters
            char ch = 'A';
            int breakpoint = (2 * i) / 2;
            for(int j = 0; j < 2 * i + 1; j++) {
                System.out.print(ch);
                if (j < breakpoint) {
                    ch++; // Increment till mid
                } else {
                    ch--; // Decrement after mid
                }
            }

            // Print trailing spaces (optional)
            System.out.println();
        }
    }


}