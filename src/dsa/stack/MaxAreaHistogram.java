package dsa.stack;

import java.util.Arrays;
import java.util.Stack;

public class MaxAreaHistogram {
    public static void main(String[] args) {
        int[] arr = new int[]{3,4,0,0};
        int ans = maxArea(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(ans);
    }

    private static int maxArea(int[] arr) {
        int left[] = getNearestSmallerOnLeftArray(arr);
        int right[] = getNearestSmallerOnRightArray(arr);
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; ++i) {
            int area = (left[i] + right[i] - 1) * arr[i];
            if (area > maxArea)
                maxArea = area;
        }
        return maxArea;
    }

    private static int[] getNearestSmallerOnRightArray(int[] arr) {
        Stack<Pair> stack = new Stack<>();
        int[] ans = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; --i) {
            int count = 0;
            if (stack.isEmpty())
                ans[i] = 1;
            else if (stack.peek().getFirst() < arr[i])
                ans[i] = 1;
            else {
                while (!stack.isEmpty() && stack.peek().getFirst() >= arr[i])
                    count += stack.pop().getSecond();
                if (stack.isEmpty())
                    ans[i] = count + 1;
                else if (stack.peek().getFirst() < arr[i])
                    ans[i] = count + 1;
            }
            stack.push(new Pair(arr[i], ans[i]));
        }
        return ans;
    }

    private static int[] getNearestSmallerOnLeftArray(int[] arr) {
        Stack<Pair> stack = new Stack<>();
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; ++i) {
            int count = 0;
            if (stack.isEmpty())
                ans[i] = 1;
            else if (stack.peek().getFirst() < arr[i])
                ans[i] = 1;
            else {
                while (!stack.isEmpty() && stack.peek().getFirst() >= arr[i]) {
                    count = count + stack.pop().getSecond();
                }
                if (stack.isEmpty())
                    ans[i] = count + 1;
                else if (stack.peek().getFirst() < arr[i])
                    ans[i] = count + 1;
            }
            stack.push(new Pair(arr[i], ans[i]));
        }
        return ans;
    }
}
