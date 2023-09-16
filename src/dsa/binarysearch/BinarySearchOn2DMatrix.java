package dsa.binarysearch;

public class BinarySearchOn2DMatrix {
    public static int floor = -1;
    public static int ceil = -1;

    public static void main(String[] args) {
        int[][] arr = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}
        };

        for (int i = 0; i < arr[0].length; ++i) {
            for (int j = 0; j < arr.length; ++j) {
                search(arr, arr[i][j]);
                System.out.print("[" + ceil + "," + floor + "], ");
                floor = -1;
                ceil = -1;
            }
            System.out.println();
        }

        search(arr, 11);
        System.out.print("[" + ceil + "," + floor + "], ");
    }

    public static void search(int[][] arr, int n) {
        int row = 0;
        int column = arr[0].length - 1;
        int prevRow = -1;
        int prevColumn = -1;

        while (row < arr.length && column >= 0) {
            binarySearchFloor(arr, 0, column, n, row);
            if (floor == -1) {
                ceil = -1;
                break;
            }
            column = floor;
            binarySearchCeil(arr, row, arr.length - 1, n, column);
            if (ceil == -1) {
                floor = -1;
                break;
            }
            row = ceil;
            if (arr[ceil][floor] == n)
                return;
            if (prevRow == row && prevColumn == column)
                return;
            else {
                prevRow = row;
                prevColumn = column;
            }
        }
    }

    private static void binarySearchFloor(int[][] arr, int start, int end, int n, int x) {
        if (start <= end) {
            int mid = (start + end) / 2;
            if (arr[x][mid] == n) {
                floor = mid;
            } else if (arr[x][mid] > n) {
                floor = mid - 1;
                binarySearchFloor(arr, start, mid - 1, n, x);
            } else {
                floor = mid;
                binarySearchFloor(arr, mid + 1, end, n, x);
            }
        }
    }

    private static void binarySearchCeil(int[][] arr, int start, int end, int n, int x) {
        if (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid][x] == n) {
                ceil = mid;
            } else if (arr[mid][x] > n) {
                ceil = mid;
                binarySearchCeil(arr, start, mid - 1, n, x);
            } else {
                ceil = mid + 1;
                binarySearchCeil(arr, mid + 1, end, n, x);
            }
        }
        if (ceil >= arr.length) ceil = -1;
    }

}

