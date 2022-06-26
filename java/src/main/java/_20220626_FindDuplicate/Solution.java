package _20220626_FindDuplicate;

public class Solution {

    public int findDuplicate(int[] nums) {
        int s = 0;
        int f = 0;

        do {
            s = nums[s];
            f = nums[nums[f]];
        } while (s != f);

        f = 0;
        while (nums[s] != nums[f]) {
            s = nums[s];
            f = nums[f];
        }
        return nums[s];
    }

}
