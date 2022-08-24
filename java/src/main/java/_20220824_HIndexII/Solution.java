package _20220824_HIndexII;

public class Solution {

  public int hIndex(int[] citations) {

    int lo = 0;
    int hi = citations.length - 1;

    while (lo <= hi) {
      int mi = lo + (hi - lo) / 2;
      if (check(citations, mi)) {
        lo = mi + 1;
      } else {
        hi = mi - 1;
      }
    }

    return lo;
  }

  private boolean check(int[] citations, int target) {
    int lo = 0;
    int hi = citations.length - 1;

    while (lo <= hi) {
      int mi = lo + (hi - lo) / 2;
      if (target < citations[mi]) {
        hi = mi - 1;
      } else {
        lo = mi + 1;
      }
    }

    return citations.length - lo - 1 >= target;
  }

}
