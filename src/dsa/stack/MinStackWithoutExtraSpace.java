package dsa.stack;

import java.util.Stack;

public class MinStackWithoutExtraSpace {
    public static void main(String[] args) {
        MinStackWithoutSpace minStack = new MinStackWithoutSpace();
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

class MinStackWithoutSpace {
    Stack<Integer> stack;
    int min;

    public MinStackWithoutSpace() {
        stack = new Stack<>();
        min = -1;
    }

    public int push(int i) {
        if (stack.isEmpty()) {
            stack.push(i);
            min = i;
        } else if (min > i) {
            stack.push(2 * i - min);
            min = i;
        } else {
            stack.push(i);
        }
        return i;
    }

    public int pop() {
        if (stack.isEmpty())
            return -1;
        else if (stack.peek() > min)
            return stack.pop();
        else {
            int x = min;
            min = 2 * min - stack.pop();
            return x;
        }
    }

    public int peek() {
        if (stack.isEmpty())
            return -1;
        else if (stack.peek() > min)
            return stack.peek();
        else {
            return min;
        }
    }

    public int min() {
        return min;
    }
}
