import java.util.*;

class Solution {
    public ArrayList<String> possibleWords(int[] arr) {
        ArrayList<String> result = new ArrayList<>();
        
        // keypad mapping
        String[] keypad = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };
        
        if (arr == null || arr.length == 0) return result;
        
        backtrack(arr, 0, "", result, keypad);
        return result;
    }
    
    private void backtrack(int[] arr, int index, String current, 
                           ArrayList<String> result, String[] keypad) {
        // base case: if we've processed all digits
        if (index == arr.length) {
            result.add(current);
            return;
        }
        
        // get possible letters for current digit
        String letters = keypad[arr[index]];
        
        // skip invalid digits (0 and 1)
        if (letters.length() == 0) {
            backtrack(arr, index + 1, current, result, keypad);
            return;
        }
        
        // explore each letter
        for (char ch : letters.toCharArray()) {
            backtrack(arr, index + 1, current + ch, result, keypad);
        }
    }
}
