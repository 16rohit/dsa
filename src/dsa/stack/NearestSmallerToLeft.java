package dsa.stack;

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerToLeft {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 0, 0, 1, 2, 4};
        int[] ans = nearestSmallerToRight(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(ans));
    }

    private static int[] nearestSmallerToRight(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[arr.length];
        for (int i = 0; i< arr.length;++i) {
            if (stack.isEmpty())
                ans[i] = -1;
            else if (stack.peek()<arr[i])
                ans[i] = stack.peek();
            else {
                while (!stack.isEmpty() && stack.peek() >= arr[i])
                    stack.pop();
                if (stack.isEmpty())
                    ans[i] = -1;
                else if (stack.peek()<arr[i])
                    ans[i] = stack.peek();
            }
            stack.push(arr[i]);
        }
        return ans;
    }

}
