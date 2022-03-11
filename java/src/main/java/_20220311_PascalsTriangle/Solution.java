package _20220311_PascalsTriangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public List<List<Integer>> generate(int numRows) {
        if (numRows <= 0) {
            return Collections.emptyList();
        }

        List<List<Integer>> result = new ArrayList<>(numRows);
        result.add(Collections.singletonList(1));

        for (int i = 2; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>(i);
            List<Integer> lastRow = result.get(i - 2);

            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    row.add(1);
                } else {
                    int num = lastRow.get(j - 1) + lastRow.get(j);
                    row.add(num);
                }

            }

            result.add(row);
        }

        return result;
    }

}
