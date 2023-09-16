package dsa.binarysearch;

public class BinarySearchFirstOccurrence {
    public static int ans = -1;

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 3, 3, 3, 3, 4, 5, 6, 7, 7};
        int n = 7;
        binarySearch(arr, 0, arr.length - 1, n);
        System.out.println(ans);
    }

    private static void binarySearch(int[] arr, int start, int end, int n) {
        if (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == n) {
                ans = mid;
                binarySearch(arr, start, mid - 1, n);
            } else if (arr[mid] > n)
                binarySearch(arr, start, mid - 1, n);
            else
                binarySearch(arr, mid + 1, end, n);
        }
    }
}
