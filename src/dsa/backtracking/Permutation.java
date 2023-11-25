package dsa.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation {
    private static List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        permute(new int[]{1,2,3});
        System.out.println(ans);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        permute(nums, arr, visited);
        return ans;
    }

    public static void permute(int[] nums, List<Integer> arr, Set<Integer> visited) {
        if (arr.size() == nums.length) {
            ans.add(new ArrayList<>(arr));
            return;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (!visited.contains(i)) {
                arr.add(nums[i]);
                visited.add(i);
                permute(nums, arr, visited);
                visited.remove(i);
                arr.remove(arr.size() - 1);
            }
        }
    }
}
