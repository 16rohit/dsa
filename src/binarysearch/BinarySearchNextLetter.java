package binarysearch;

public class BinarySearchNextLetter {
    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'f', 'h'};
        for (int i = 0; i < arr.length; ++i) {
            int ans = binarySearch(arr, 0, arr.length - 1, arr[i]);
            System.out.println(ans);
        }
    }

    private static int binarySearch(char[] arr, int start, int end, char n) {
        if (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == n) {
                if (mid == arr.length - 1) return -1;
                else return mid + 1;
            } else if (arr[mid] > n)
                return binarySearch(arr, start, mid - 1, n);
            else
                return binarySearch(arr, mid + 1, end, n);
        }
        return -1;
    }
}
