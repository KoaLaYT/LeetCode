package _20220824_HIndex;

import java.util.Arrays;

public class Solution {

  public int hIndex(int[] citations) {
    Arrays.sort(citations);
    int h = 0;
    int i = citations.length - 1;
    while (i >= 0 && citations[i] > h) {
      h += 1;
      i -= 1;
    }
    return h;
  }

}
