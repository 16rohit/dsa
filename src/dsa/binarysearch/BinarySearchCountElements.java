package dsa.binarysearch;

public class BinarySearchCountElements {
    public static int x = -1;
    public static int y = -1;

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 3, 3, 3, 3, 4, 5, 6, 7, 7};
        int n = 7;
        binarySearch(arr, 0, arr.length - 1, n, true);
        binarySearch(arr, 0, arr.length - 1, n, false);
        if (x == -1)
            System.out.println(-1);
        else
            System.out.println(y - x + 1);
    }

    private static void binarySearch(int[] arr, int start, int end, int n, boolean isStart) {
        if (start <= end) {
            int mid = (start + end) / 2;
            if (isStart) {
                if (arr[mid] == n) {
                    x = mid;
                    binarySearch(arr, start, mid - 1, n, isStart);
                } else if (arr[mid] > n)
                    binarySearch(arr, start, mid - 1, n, isStart);
                else
                    binarySearch(arr, mid + 1, end, n, isStart);
            } else {
                if (arr[mid] == n) {
                    y = mid;
                    binarySearch(arr, mid + 1, end, n, isStart);
                } else if (arr[mid] > n)
                    binarySearch(arr, start, mid - 1, n, isStart);
                else
                    binarySearch(arr, mid + 1, end, n, isStart);
            }
        }
    }
}
