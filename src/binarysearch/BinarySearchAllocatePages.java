package binarysearch;

public class BinarySearchAllocatePages {
    public static int ans = -1;

    public static void main(String[] args) {
        int[] arr = {100};
        int n = 2;
        int sum = 0;
        int start = Integer.MIN_VALUE;

        if (n <= arr.length) {
            for (int i = 0; i < arr.length; ++i) {
                if (start < arr[i])
                    start = arr[i];
                sum += arr[i];
            }
            binarySearch(arr, start, sum, n);
        }
        System.out.println(ans);
    }

    private static void binarySearch(int[] arr, int start, int end, int n) {
        if (start <= end) {
            int mid = (start + end) / 2;
            if (isValid(arr, mid, n)) {
                ans = mid;
                binarySearch(arr, start, mid - 1, n);
            } else {
                binarySearch(arr, mid + 1, end, n);
            }
        }
    }

    private static boolean isValid(int[] arr, int mid, int n) {
        int requiredNoOfStudents = 1;
        int currentSum = 0;
        for (int i = 0; i < arr.length; ++i) {
            currentSum += arr[i];
            if (currentSum > mid) {
                requiredNoOfStudents++;
                currentSum = arr[i];
            }
        }
        if (requiredNoOfStudents > n)
            return false;
        else
            return true;
    }
}
