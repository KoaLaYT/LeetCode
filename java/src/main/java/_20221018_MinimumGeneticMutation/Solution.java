package _20221018_MinimumGeneticMutation;

public class Solution {

    public int minMutation(String start, String end, String[] bank) {
        boolean[] used = new boolean[bank.length];
        return minMutation(start, end, bank, used, 0);
    }

    private int minMutation(String start, String end, String[] bank, boolean[] used, int count) {
        if (start.equals(end)) {
            return count;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < bank.length; i++) {
            if (used[i]) continue;
            if (!isOneMutation(start, bank[i])) continue;
            used[i] = true;
            int res = minMutation(bank[i], end, bank, used, count + 1);
            if (res != -1) {
                min = Math.min(min, res);
            }
            used[i] = false;
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    // preconditions:
    // 1. a.length == b.length
    // 2. a, b only contains ATCG
    private boolean isOneMutation(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff += 1;
            }
        }
        return diff == 1;
    }

}
