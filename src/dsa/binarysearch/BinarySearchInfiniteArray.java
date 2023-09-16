package dsa.binarysearch;

public class BinarySearchInfiniteArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 3, 5, 6, 7};
        for (int i = 0; i < arr.length; ++i) {
            int ans = binarySearch(arr, 0, 2, arr[i]);
            System.out.println(ans);
        }
    }

    private static int binarySearch(int[] arr, int start, int end, int n) {
        if (arr[end] == n)
            return end;
        else if (arr[start] <= n && arr[end] > n) {
            int mid = (start + end) / 2;
            if (arr[mid] == n)
                return mid;
            else if (arr[mid] > n)
                return binarySearch(arr, start, mid - 1, n);
            else
                return binarySearch(arr, mid + 1, end, n);
        } else
            return binarySearch(arr, end + 1, end * 2, n);
    }
}
