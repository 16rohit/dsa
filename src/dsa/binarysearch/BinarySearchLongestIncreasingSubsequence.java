package dsa.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchLongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] arr = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lis(arr));

    }

    public static int lis(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; ++i) {
            if (list.isEmpty()) {
                list.add(nums[i]);
            } else if (nums[i] > list.get(list.size() - 1)) {
                list.add(nums[i]);
            } else {
                int index = upperbound(list, 0, list.size() - 1, nums[i]);
                list.set(index, nums[i]);
            }
        }
        return list.size();
    }

    public static int upperbound(List<Integer> list, int start, int end, int num) {
        if (start <= end) {
            int mid = end - ((end - start) / 2);
            if (num == list.get(mid))
                return mid;
            else if (num < list.get(mid))
                return upperbound(list, start, mid - 1, num);
            else
                return upperbound(list, mid + 1, end, num);
        }
        if (start >= list.size())
            return -1;
        return start;
    }
}

