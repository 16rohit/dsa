package binarysearch;

public class BinarySearchDescendingOrder {

    public static void main(String[] args) {
        int[] arr = {7, 6, 5, 4, 3, 2, 1};
        int n = 4;
        int ans = binarySearch(arr, 0, arr.length - 1, n);
        System.out.println(ans);
    }

    private static int binarySearch(int[] arr, int start, int end, int n) {
        if (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == n)
                return mid;
            else if (arr[mid] > n)
                return binarySearch(arr, mid + 1, end, n);
            else
                return binarySearch(arr, start, mid - 1, n);
        }
        return -1;
    }
}
