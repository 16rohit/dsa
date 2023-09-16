package dsa.binarysearch;

public class BinarySearchRotationCount {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int ans = binarySearch(arr, 0, arr.length - 1);
        System.out.println(ans);
    }

    private static int binarySearch(int[] arr, int start, int end) {
        if (start <= end) {
            int mid = (start + end) / 2;
            if (mid == 0 || mid == arr.length - 1)
                return mid;
            else if (arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1])
                return mid;
            else if (arr[mid] < arr[end])
                return binarySearch(arr, start, mid - 1);
            else
                return binarySearch(arr, mid + 1, end);
        }
        return -1;
    }
}
