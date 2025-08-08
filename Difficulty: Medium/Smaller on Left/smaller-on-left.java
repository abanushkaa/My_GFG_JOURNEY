class Solution {
    public int[] leftSmaller(int[] arr) {
        // code here
        int n=arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek(); // largest smaller on left
            }
            stack.push(arr[i]);
        }
        
        return result;
    }
}