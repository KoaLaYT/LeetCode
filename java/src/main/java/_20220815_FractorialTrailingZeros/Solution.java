package _20220815_FractorialTrailingZeros;

public class Solution {

  public int trailingZeroes(int n) {
    int zeros = 0;
    while (n > 0) {
      n /= 5;
      zeros += n;
    }
    return zeros;
  }

}
