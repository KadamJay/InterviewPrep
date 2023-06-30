package Essential150.Stack;

/*

Problem    :   https://leetcode.com/problems/min-stack/description/
Solutions  :   https://youtu.be/qkLl7nAwDPo
Approaches :

| No. | Approach                             | Time Complexity | Space Complexity |
|-----|--------------------------------------|-----------------|------------------|
|  1  | Stack                                |       O(1)      |       O(n)       |

Time complexity: O(1) for all operations (push, pop, top, getMin).
Space complexity: O(n), where n is the number of elements in the stack.
*/

import java.util.Stack;

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        this.stack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || minStack.peek() >= val) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        // Test case 1: Push elements and get minimum
        minStack.push(3);
        minStack.push(5);
        minStack.push(2);
        minStack.push(1);
        System.out.println("Minimum element: " + minStack.getMin()); // Expected: 1

        // Test case 2: Pop elements and get minimum
        minStack.pop();
        minStack.pop();
        System.out.println("Minimum element: " + minStack.getMin()); // Expected: 2

        // Test case 3: Push duplicate minimum elements
        minStack.push(1);
        minStack.push(1);
        System.out.println("Minimum element: " + minStack.getMin()); // Expected: 1

        // Test case 4: Pop minimum elements
        minStack.pop();
        System.out.println("Minimum element: " + minStack.getMin()); // Expected: 1

        // Test case 5: Pop all elements
        minStack.pop();
        minStack.pop();
        System.out.println("Minimum element: " + minStack.getMin()); // Expected: 3
    }
}
