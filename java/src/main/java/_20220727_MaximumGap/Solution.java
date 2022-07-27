package _20220727_MaximumGap;

public class Solution {

    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }

        int min = nums[0];
        int max = nums[0];
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        if (min == max) {
            return 0;
        }

        int dist = (int) Math.ceil((double) (max - min) / (nums.length - 1));
        int len = (int) Math.ceil((double) (max - min) / dist);

        if (len == 1) {
            return max - min;
        }

        int[][] buckets = new int[len][2];
        for (int i = 0; i < len; i++) {
            buckets[i][0] = Integer.MAX_VALUE;
            buckets[i][1] = -1;
        }

        for (int num : nums) {
            int index = Math.min((num - min) / dist, len - 1);
            buckets[index][0] = Math.min(buckets[index][0], num);
            buckets[index][1] = Math.max(buckets[index][1], num);
        }

        int gap = 0;
        for (int[] bucket : buckets) {
            if (bucket[1] < 0) continue;
            gap = Math.max(gap, bucket[0] - min);
            min = bucket[1];
        }

        return gap;
    }

}
