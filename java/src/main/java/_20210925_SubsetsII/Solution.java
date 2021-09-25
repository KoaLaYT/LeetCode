package _20210925_SubsetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author koalayt 2021-09-25
 */
public class Solution {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.emptyList());

        int lastNum = Integer.MIN_VALUE;
        int lastPushedSize = 0;
        for (int num : nums) {
            int size = result.size();
            int startIndex = num != lastNum ? 0 : size - lastPushedSize;
            lastPushedSize = 0;
            for (int j = startIndex; j < size; j++) {
                List<Integer> subset = new ArrayList<>(result.get(j));
                subset.add(num);
                result.add(subset);
                lastPushedSize++;
            }
            lastNum = num;
        }

        return result;
    }

}
