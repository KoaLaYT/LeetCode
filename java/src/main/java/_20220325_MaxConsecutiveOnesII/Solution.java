package _20220325_MaxConsecutiveOnesII;

public class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {
        int s1 = 0;
        int s2 = 0;
        int max = 0;

        for (int num : nums) {
            if (num == 0) {
                s1 = s2 + 1;
                s2 = 0;
            } else {
                s1++;
                s2++;
            }
            max = Math.max(max, s1);
        }

        return max;
    }

}
