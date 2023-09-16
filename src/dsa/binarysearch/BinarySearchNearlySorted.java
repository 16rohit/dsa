package dsa.binarysearch;

public class BinarySearchNearlySorted {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 3, 5, 6, 7};
        for (int i = 0; i < arr.length; ++i) {
            int ans = binarySearch(arr, 0, arr.length - 1, arr[i]);
            System.out.println(ans);
        }
    }

    private static int binarySearch(int[] arr, int start, int end, int n) {
        if (start <= end) {
            int mid = (start + end) / 2;
            int prev = mid == 0 ? mid : mid - 1;
            int next = mid == arr.length - 1 ? mid : mid + 1;
            if (arr[mid] == n)
                return mid;
            else if (arr[prev] == n)
                return prev;
            else if (arr[next] == n)
                return next;
            else if (arr[mid] > n)
                return binarySearch(arr, start, mid - 1, n);
            else
                return binarySearch(arr, mid + 1, end, n);
        }
        return -1;
    }
}
