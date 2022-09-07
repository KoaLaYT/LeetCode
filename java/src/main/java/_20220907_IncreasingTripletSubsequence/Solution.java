package _20220907_IncreasingTripletSubsequence;

public class Solution {

  public boolean increasingTriplet(int[] nums) {
    if (nums == null || nums.length < 3) {
      return false;
    }

    int first = nums[0];
    int second = Integer.MAX_VALUE;

    for (int i = 1; i < nums.length; i++) {
      int num = nums[i];
      if (num > second) {
        return true;
      }
      if (num > first) {
        second = num;
      } else {
        first = num;
      }
    }

    return false;
  }

}
