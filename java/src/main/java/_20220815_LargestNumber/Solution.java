package _20220815_LargestNumber;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public String largestNumber(int[] nums) {
    boolean allZeros = true;
    for (int num : nums) {
      if (num != 0) {
        allZeros = false;
        break;
      }
    }

    if (allZeros) {
      return "0";
    }

    List<String> strnums = new ArrayList<>(nums.length);
    for (int num : nums) {
      strnums.add(String.valueOf(num));
    }

    strnums.sort((s1, s2) -> {
      int i = 0;
      int j = 0;

      while (i < s1.length() || j < s2.length()) {
        if (i >= s1.length()) {
          i = 0;
        }
        if (j >= s2.length()) {
          j = 0;
        }
        if (s1.charAt(i) > s2.charAt(j)) {
          return -1;
        }
        if (s1.charAt(i) < s2.charAt(j)) {
          return 1;
        }
        i++;
        j++;
      }

      return 0;
    });

    StringBuilder sb = new StringBuilder();
    for (String n : strnums) {
      sb.append(n);
    }
    return sb.toString();
  }

}
