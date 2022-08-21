package _20220821_CombinationSumIII;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> comb = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[10];
        combinationSum(k, n, 0, used, comb, result);
        return result;
    }

    private void combinationSum(
            int k,
            int n,
            int i,
            boolean[] used,
            List<Integer> comb,
            List<List<Integer>> result
    ) {
        if (n == 0 && i == k) {
            List<Integer> copy = new ArrayList<>(comb);
            result.add(copy);
            return;
        }

        if (n <= 0 || i >= k) {
            return;
        }

        int next = comb.isEmpty() ? 1 : comb.get(comb.size() - 1) + 1;
        for (int j = next; j <= 9; j++) {
            if (used[j]) continue;
            if (j > n) continue;
            used[j] = true;
            comb.add(j);
            combinationSum(k, n - j, i + 1, used, comb, result);
            comb.remove(comb.size() - 1);
            used[j] = false;
        }
    }

}
