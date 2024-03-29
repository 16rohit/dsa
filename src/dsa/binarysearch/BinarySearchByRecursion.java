package dsa.binarysearch;

public class BinarySearchByRecursion {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int n = 8;
        int ans = binarySearch(arr, 0, arr.length - 1, n);
        System.out.println(ans);
    }

    private static int binarySearch(int[] arr, int start, int end, int n) {
        if (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == n) return mid;
            else if (arr[mid] > n) return binarySearch(arr, start, mid - 1, n);
            else return binarySearch(arr, mid + 1, end, n);
        }
        return -1;
    }
}
