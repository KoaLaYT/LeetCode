package _20220813_SingleNumberII;

public class Solution {

  public int singleNumber(int[] nums) {
    int[] bits = new int[32];
    for (int num : nums) {
      for (int i = 0; i < 32; i++) {
        bits[i] += (num >> i) & 1;
      }
    }

    int single = 0;
    for (int i = 0; i < 32; i++) {
      single |= (bits[i] % 3) << i;
    }
    return single;
  }

}
