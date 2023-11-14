package dsa.stack;

import java.util.Stack;

public class MinStackWithExtraSpace {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(18);
        System.out.println(minStack.min());
        minStack.push(19);
        System.out.println(minStack.min());
        minStack.push(29);
        System.out.println(minStack.min());
        minStack.push(15);
        System.out.println(minStack.min());
        minStack.push(16);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());

    }
}

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> supportingStack;

    public MinStack() {
        stack = new Stack<>();
        supportingStack = new Stack<>();
    }

    public int push(int i) {
        stack.push(i);
        if (supportingStack.isEmpty() || supportingStack.peek() > i)
            supportingStack.push(i);

        return i;
    }

    public int pop() {
        int i = stack.pop();
        if (i == supportingStack.peek())
            supportingStack.pop();

        return i;
    }

    public int peek() {
        return stack.peek();
    }

    public int min() {
        return supportingStack.peek();
    }
}
