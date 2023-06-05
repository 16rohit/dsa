package binarysearch;

public class BinarySearchByIteration {

    private static int binarySearch(int[] arr, int start, int end, int n) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == n) return mid;
            else if (arr[mid] > n) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7};
        int n = 1;
        int ans = binarySearch(arr, 0, arr.length - 1, n);
        System.out.println(ans);
    }
}
