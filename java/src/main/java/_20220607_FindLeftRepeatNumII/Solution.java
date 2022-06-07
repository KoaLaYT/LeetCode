package _20220607_FindLeftRepeatNumII;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] find_left_repeat_numII(int[] nums) {
        Map<Integer, Integer> memo = new HashMap<>();
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            result[i] = memo.getOrDefault(num, -1);
            memo.put(num, i);
        }

        return result;
    }

}
