package _20220814_FractionToRecurringDecimal;

import java.util.HashMap;
import java.util.Map;

public class Solution {

  public String fractionToDecimal(int numerator, int denominator) {
    if (numerator == 0) {
      return "0";
    }

    char prefix = '-';
    if ((numerator > 0 && denominator > 0) || (numerator < 0 && denominator < 0)) {
      prefix = '\0';
    }

    return fractionToDecimal(Math.abs((long) numerator), Math.abs((long) denominator), prefix);
  }

  public String fractionToDecimal(long numerator, long denominator, char prefix) {
    StringBuilder sb = new StringBuilder();

    if (prefix != '\0') {
      sb.append(prefix);
    }

    sb.append(numerator / denominator);
    if (numerator % denominator == 0) {
      return sb.toString();
    }
    sb.append('.');

    long cur = numerator % denominator * 10L;
    Map<Long, Integer> tbl = new HashMap<>();
    int index = sb.length();

    while (true) {
      if (tbl.containsKey(cur)) {
        sb.insert(tbl.get(cur).intValue(), '(');
        sb.append(')');
        break;
      }

      long res = cur / denominator;
      long fra = cur % denominator;

      sb.append(res);

      if (fra == 0L) {
        break;
      }

      tbl.put(cur, index++);
      cur = fra * 10;
    }

    return sb.toString();
  }

}
