package _20220306_SubarraySumsDivisibleByK;

public class Solution {

    public int subarraysDivByK(int[] nums, int k) {
        int sum = 0;
        int[] mods = new int[k];
        mods[0] = 1;

        for (int num : nums) {
            sum += num;
            mods[Math.floorMod(sum, k)] += 1;
        }

        int count = 0;
        for (int i = 0; i < k; i++) {
            count += mods[i] * (mods[i] - 1) / 2;
        }
        return count;
    }

}
