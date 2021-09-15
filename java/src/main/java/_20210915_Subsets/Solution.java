package _20210915_Subsets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author koalayt 2021-09-15
 */
public class Solution {

    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        LinkedList<Integer> subset = new LinkedList<>();
        for (int i = 0; i <= nums.length; i++) {
            subsets(nums, 0, i, subset);
        }
        return result;
    }

    private void subsets(int[] nums, int index, int size, LinkedList<Integer> subset) {
        if (size == 0) {
            result.add(new ArrayList<>(subset));
            return;
        }

        for (int i = index; i < nums.length - size + 1; i++) {
            subset.addLast(nums[i]);
            subsets(nums, i + 1, size - 1, subset);
            subset.removeLast();
        }
    }
}
