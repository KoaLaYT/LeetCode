package _20220813_GasStation;

public class Solution {

  public int canCompleteCircuit(int[] gas, int[] cost) {
    int n = gas.length;
    int sum = 0;
    int left = 0;
    int start = 0;

    for (int i = 0; i < n; i++) {
      int delta = gas[i] - cost[i];
      left += delta;
      sum += delta;
      if (left < 0) {
        left = 0;
        start = i + 1;
      }
    }

    if (sum < 0) {
      return -1;
    }
    return start;
  }

}
