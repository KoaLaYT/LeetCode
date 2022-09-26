package _20220926_RandomPickIndex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class Solution {

    private final Map<Integer, List<Integer>> map;

    public Solution(int[] nums) {
        this.map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            map.putIfAbsent(num, new ArrayList<>());
            map.get(num).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> indexes = map.get(target);
        return random(indexes);
    }

    private static int random(List<Integer> arr) {
        int index = ThreadLocalRandom.current().nextInt(arr.size());
        return arr.get(index);
    }

}
