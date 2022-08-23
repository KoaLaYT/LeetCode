package _20220823_SingleNumberIII;

public class Solution {

  public int[] singleNumber(int[] nums) {
    int xorsum = 0;
    for (int num : nums) {
      xorsum ^= num;
    }

    int lsp = xorsum == Integer.MIN_VALUE ? xorsum : (xorsum & (-xorsum));
    int type1 = 0;
    int type2 = 0;

    for (int num : nums) {
      if ((num & lsp) != 0) {
        type1 ^= num;
      } else {
        type2 ^= num;
      }
    }

    return new int[]{type1, type2};
  }

}
