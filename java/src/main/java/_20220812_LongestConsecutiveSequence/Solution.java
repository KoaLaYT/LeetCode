package _20220812_LongestConsecutiveSequence;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int max = 0;

        for (int num : nums) {
            if (set.contains(num - 1)) continue;
            int v = num + 1;
            int len = 1;
            while (set.contains(v)) {
                v += 1;
                len += 1;
            }
            max = Math.max(max, len);
        }

        return max;
    }

}
