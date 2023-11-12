package dsa.stack;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {
        int[] arr = new int[]{100, 80, 60, 70, 60, 75, 85};
        int[] ans = countSmallOnLeft(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(ans));
    }

    private static int[] countSmallOnLeft(int[] arr) {
        Stack<Pair> stack = new Stack<>();
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            int count = 0;
            if (stack.isEmpty())
                ans[i] = 1;
            else if (stack.peek().getFirst() > arr[i])
                ans[i] = 1;
            else {
                while (!stack.isEmpty() && stack.peek().getFirst() <= arr[i]) {
                    Pair p = stack.pop();
                    count += p.getSecond();
                }
                if (stack.isEmpty())
                    ans[i] = 1 + count;
                else if (stack.peek().getFirst() > arr[i])
                    ans[i] = 1 + count;
            }
            stack.push(new Pair(arr[i], count + 1));
        }
        return ans;
    }
}

class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }
}