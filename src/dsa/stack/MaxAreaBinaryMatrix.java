package dsa.stack;

import java.util.Arrays;
import java.util.Stack;

public class MaxAreaBinaryMatrix {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0}
        };

        int[] sumArr = new int[arr.length];
        for (int i = 0; i < arr[0].length; ++i) {
            sumArr[i] = arr[0][i];
        }
        int maxArea = maxArea(sumArr);
        System.out.println("Array Passed: " + Arrays.toString(sumArr) + " ans = " + maxArea);
        for (int i = 1; i < arr.length; ++i) {
            for (int j = 0; j < arr[0].length; ++j) {
                if (arr[i][j] == 0)
                    sumArr[j] = 0;
                else sumArr[j] = sumArr[j] + arr[i][j];
            }
            int area = maxArea(sumArr);
            System.out.println("Array Passed: " + Arrays.toString(sumArr) + " ans = " + area);
            if (maxArea < area)
                maxArea = area;
        }
        System.out.println(maxArea);
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
