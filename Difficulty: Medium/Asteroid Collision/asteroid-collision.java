// User function Template for Java

class Solution {
    public static int[] asteroidCollision(int N, int[] asteroids) {
        // Using stack to store remaining asteroids
        java.util.Stack<Integer> stack = new java.util.Stack<>();
        
        for (int a : asteroids) {
            boolean destroyed = false;
            
            // Collision only possible if stack top is moving right (positive) and current asteroid is moving left (negative)
            while (!stack.isEmpty() && stack.peek() > 0 && a < 0) {
                int top = stack.peek();
                if (Math.abs(top) < Math.abs(a)) {
                    // Top asteroid is smaller → it gets destroyed
                    stack.pop();
                    continue; // Check again with the next asteroid in stack
                } else if (Math.abs(top) == Math.abs(a)) {
                    // Both same size → both destroyed
                    stack.pop();
                    destroyed = true;
                    break; // No asteroid to push
                } else {
                    // Top asteroid is bigger → current asteroid destroyed
                    destroyed = true;
                    break;
                }
            }
            
            // If current asteroid survived, push it
            if (!destroyed) {
                stack.push(a);
            }
        }
        
        // Convert stack to array
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}

