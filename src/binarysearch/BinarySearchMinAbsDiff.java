package binarysearch;

public class BinarySearchMinAbsDiff {
    public static int minDiff = Integer.MAX_VALUE;
    public static int ans = -1;

    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 10};
        binarySearch(arr, 0, arr.length - 1, 11);
        System.out.println(ans);
    }

    private static void binarySearch(int[] arr, int start, int end, int n) {
        if (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == n) {
                minDiff = 0;
                ans = mid;
            } else if (arr[mid] > n) {
                if (minDiff > Math.abs(arr[mid] - n)) {
                    ans = mid;
                    minDiff = Math.abs(arr[mid] - n);
                }
                binarySearch(arr, start, mid - 1, n);
            } else {
                if (minDiff > Math.abs(arr[mid] - n)) {
                    ans = mid;
                    minDiff = Math.abs(arr[mid] - n);
                }
                binarySearch(arr, mid + 1, end, n);
            }
        }
    }
}
