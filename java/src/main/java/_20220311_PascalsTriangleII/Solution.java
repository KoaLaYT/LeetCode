package _20220311_PascalsTriangleII;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> curr = Collections.emptyList();

        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> next = new ArrayList<>(i + 1);
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    next.add(1);
                } else {
                    next.add(curr.get(j - 1) + curr.get(j));
                }
            }
            curr = next;
        }
        return curr;
    }

}
