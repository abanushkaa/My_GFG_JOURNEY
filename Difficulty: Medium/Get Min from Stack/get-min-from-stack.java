class Solution {
    Stack <Integer> mainStack;
    Stack <Integer> minStack;
    public Solution() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    // Add an element to the top of Stack
    public void push(int x) {
        // code here
        mainStack.push(x);
        if(minStack.isEmpty() || x<= minStack.peek()){
            minStack.push(x);
        }
        
    }

    // Remove the top element from the Stack
    public void pop() {
        if(!mainStack.isEmpty()){
            int removed= mainStack.pop();
            if(!minStack.isEmpty() && removed == minStack.peek()){
                minStack.pop();
            }
        }
        // code here
    }

        // Returns top element of the Stack
    public int peek() {
        if (mainStack.isEmpty()) return -1;
        return mainStack.peek();
    }

    // Finds minimum element of Stack
    public int getMin() {
        if (minStack.isEmpty()) return -1;
        return minStack.peek();
    }
}
