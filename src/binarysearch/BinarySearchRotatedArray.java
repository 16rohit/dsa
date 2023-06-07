package binarysearch;

public class BinarySearchRotatedArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        for (int i = 0; i < arr.length; ++i) {
            int ans = binarySearch(arr, 0, arr.length - 1, arr[i]);
            System.out.println(ans);
        }
    }

    private static int binarySearch(int[] arr, int start, int end, int n) {
        if (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == n)
                return mid;
            else if (arr[start] < arr[mid]) {
                if (arr[mid] > n && arr[start] <= n)
                    return binarySearch(arr, start, mid - 1, n);
                else
                    return binarySearch(arr, mid + 1, end, n);
            } else {
                if (arr[mid] < n && arr[end] >= n)
                    return binarySearch(arr, mid + 1, end, n);
                else
                    return binarySearch(arr, start, mid - 1, n);
            }
        }
        return -1;
    }
}
