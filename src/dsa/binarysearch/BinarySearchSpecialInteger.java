package dsa.binarysearch;

/*
Given an array of integers A and an integer B,
find and return the maximum value K such that
there is no sub-array in A of size K with the sum of elements greater than B.

Input 1:
    A = [1, 2, 3, 4, 5]
    B = 10
Output 1:
    2

Input 2:
    A = [5, 17, 100, 11]
    B = 130
Output 2:
    3
 */


public class BinarySearchSpecialInteger {
    public static void main(String[] args) {
        int[] arr = {5, 17, 100, 11};
        int n = 130;
        int ans = binarySearch(arr, 0, arr.length - 1, n);
    }

    private static int binarySearch(int[] arr, int start, int end, int n) {
        if (start <= end) {
            int mid = (start + end) / 2;
//            if (isSumSubArrayUnderN(arr, start, end, n)) {
//
//            }
        }
        return 0;
    }
}
