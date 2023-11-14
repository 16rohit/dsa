package dsa.stack;

import java.util.Arrays;

public class RainWaterTrapping {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 0, 0, 2, 0, 4};
        int ans = maxWaterTrapped(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(ans);
    }

    private static int maxWaterTrapped(int[] arr) {
        int sum = 0;
//        int[] left = maxLeftArr(arr);
        int maxLeft = Integer.MIN_VALUE;
        int[] right = maxRightArr(arr);
        for (int i = 0; i < arr.length; ++i) {
            maxLeft = Math.max(maxLeft, arr[i]);
            sum += Math.min(maxLeft, right[i]) - arr[i];
        }
        return sum;
    }

    private static int[] maxLeftArr(int[] arr) {
        int[] maxArr = new int[arr.length];
        maxArr[0] = arr[0];
        for (int i = 1; i < arr.length; ++i) {
            maxArr[i] = Math.max(arr[i], maxArr[i - 1]);
        }
        return maxArr;
    }

    private static int[] maxRightArr(int[] arr) {
        int[] maxArr = new int[arr.length];
        maxArr[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; --i) {
            maxArr[i] = Math.max(arr[i], maxArr[i + 1]);
        }
        return maxArr;
    }

}
