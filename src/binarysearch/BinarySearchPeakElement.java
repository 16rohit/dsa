package binarysearch;

public class BinarySearchPeakElement {

    public static void main(String[] args) {
        int[] arr = {10, 6, 2, 1};
        int ans = binarySearch(arr, 0, arr.length - 1);
        System.out.println(ans);
    }

    private static int binarySearch(int[] arr, int start, int end) {
        if (start <= end) {
            int mid = (start + end) / 2;
            if (mid == 0 && arr[mid] > arr[mid + 1])
                return mid;
            else if (mid == arr.length - 1 && arr[mid] > arr[mid - 1])
                return mid;
            else if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1])
                return mid;
            else if (arr[mid] < arr[mid - 1])
                return binarySearch(arr, start, mid - 1);
            else
                return binarySearch(arr, mid + 1, end);
        }
        return -1;
    }
}
