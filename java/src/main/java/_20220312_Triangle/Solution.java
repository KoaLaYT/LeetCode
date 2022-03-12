package _20220312_Triangle;

import java.util.List;

public class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        if (size <= 0) {
            return 0;
        }
        int total = triangle.get(0).get(0);
        for (int i = 1; i < size; i++) {
            List<Integer> pre = triangle.get(i - 1);
            List<Integer> cur = triangle.get(i);
            for (int j = 0; j < cur.size(); j++) {
                if (j == 0) {
                    cur.set(j, pre.get(j) + cur.get(j));
                    total = cur.get(0);
                    continue;
                }
                if (j == cur.size() - 1) {
                    cur.set(j, pre.get(j - 1) + cur.get(j));
                } else {
                    cur.set(j, Math.min(pre.get(j - 1), pre.get(j)) + cur.get(j));
                }
                total = Math.min(total, cur.get(j));
            }
        }
        return total;
    }

}
