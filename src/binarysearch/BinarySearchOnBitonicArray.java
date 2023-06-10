package binarysearch;

public class BinarySearchOnBitonicArray {
    public static void main(String[] args) {
        int[] arr = {3, 4, 10, 6, 2, 1};
        int ans = binarySearch(arr, 0, arr.length - 1, 3);
        System.out.println(ans);
    }

    private static int binarySearch(int[] arr, int start, int end, int n) {
        int peak = binarySearchToFindPeak(arr, start, end);
        int left = binarySearchAsc(arr, start, peak, n);
        int right = -1;
        if (peak != arr.length - 1)
            right = binarySearchDesc(arr, peak + 1, end, n);
        if (left == -1 && right == -1)
            return -1;
        else if (left == -1)
            return right;
        else
            return left;
    }

    private static int binarySearchToFindPeak(int[] arr, int start, int end) {
        if (arr.length == 1)
            return 0;
        if (start <= end) {
            int mid = (start + end) / 2;
            if (mid == 0 && arr[mid] > arr[mid + 1])
                return mid;
            else if (mid == arr.length - 1 && arr[mid] > arr[mid - 1])
                return mid;
            else if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
                return mid;
            else if (arr[mid] < arr[mid - 1])
                return binarySearchToFindPeak(arr, start, mid - 1);
            else
                return binarySearchToFindPeak(arr, mid + 1, end);
        }
        return -1;
    }

    private static int binarySearchAsc(int[] arr, int start, int end, int n) {
        if (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == n)
                return mid;
            else if (arr[mid] > n)
                return binarySearchAsc(arr, start, mid - 1, n);
            else
                return binarySearchAsc(arr, mid + 1, end, n);
        }
        return -1;
    }

    private static int binarySearchDesc(int[] arr, int start, int end, int n) {
        if (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == n)
                return mid;
            else if (arr[mid] < n)
                return binarySearchAsc(arr, start, mid - 1, n);
            else
                return binarySearchAsc(arr, mid + 1, end, n);
        }
        return -1;
    }
}
