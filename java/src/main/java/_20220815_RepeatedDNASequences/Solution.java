package _20220815_RepeatedDNASequences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

  public List<String> findRepeatedDnaSequences(String s) {
    if (s.length() <= 10) {
      return Collections.emptyList();
    }

    Set<String> appeared = new HashSet<>();
    Set<String> repeated = new HashSet<>();

    for (int i = 0; i + 10 <= s.length(); i++) {
      String sub = s.substring(i, i + 10);
      boolean isNew = appeared.add(sub);
      if (!isNew) {
        repeated.add(sub);
      }
    }

    return new ArrayList<>(repeated);
  }

}
