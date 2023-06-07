package binarysearch;

public class BinarySearchFloorOfElement {
    public static int ans = -1;

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6, 7};
        binarySearch(arr, 0, arr.length - 1, 3);
        System.out.println(ans);
    }

    private static void binarySearch(int[] arr, int start, int end, int n) {
        if (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == n) {
                ans = mid;
            } else if (arr[mid] > n) {
                ans = mid - 1;
                binarySearch(arr, start, mid - 1, n);
            } else {
                ans = mid;
                binarySearch(arr, mid + 1, end, n);
            }
        }
    }
}
