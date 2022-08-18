package _20220818_MajorityElementII;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public List<Integer> majorityElement(int[] nums) {
    int m1 = 0;
    int m2 = 0;
    int c1 = 0;
    int c2 = 0;

    for (int num : nums) {
      if (c1 > 0 && m1 == num) {
        c1++;
        continue;
      }

      if (c2 > 0 && m2 == num) {
        c2++;
        continue;
      }

      if (c1 == 0) {
        m1 = num;
        c1 = 1;
        continue;
      }

      if (c2 == 0) {
        m2 = num;
        c2 = 1;
        continue;
      }

      c1--;
      c2--;
    }

    if (c1 > 0) {
      c1 = 0;
      for (int num : nums) {
        if (m1 == num) {
          c1++;
        }
      }
    }

    if (c2 > 0) {
      c2 = 0;
      for (int num : nums) {
        if (m2 == num) {
          c2++;
        }
      }
    }

    int m = nums.length / 3;

    List<Integer> result = new ArrayList<>(2);
    if (c1 > m) {
      result.add(m1);
    }
    if (c2 > m) {
      result.add(m2);
    }

    return result;
  }

}
