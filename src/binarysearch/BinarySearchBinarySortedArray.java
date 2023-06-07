package binarysearch;

public class BinarySearchBinarySortedArray {
    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1};
        int ans = binarySearch(arr, 0, arr.length - 1);
        System.out.println(ans);
    }

    private static int binarySearch(int[] arr, int start, int end) {
        if (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == 0)
                return binarySearch(arr, mid + 1, end);
            else if (mid == 0) {
                if (arr[mid] == 1) return mid;
                else return -1;
            } else if (arr[mid] == 1) {
                if (arr[mid - 1] == 0)
                    return mid;
                else
                    return binarySearch(arr, start, mid - 1);
            }
        }
        return -1;
    }
}
