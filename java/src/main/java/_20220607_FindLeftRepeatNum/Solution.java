package _20220607_FindLeftRepeatNum;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] find_left_repeat_num(int[] nums) {
        Map<Integer, Integer> memo = new HashMap<>();
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (memo.containsKey(num)) {
                result[i] = memo.get(num);
            } else {
                memo.put(num, i);
                result[i] = -1;
            }
        }

        return result;
    }

}
