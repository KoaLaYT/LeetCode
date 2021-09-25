package _20210925_GrayCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author koalayt 2021-09-25
 */
public class Solution {

    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>(1 << n);
        grayCode(result, n);
        return result;
    }

    private void grayCode(List<Integer> result, int n) {
        if (n <= 0) {
            result.add(0);
            return;
        }

        grayCode(result, n - 1);

        int m = 1 << (n - 1);
        for (int i = m - 1; i >= 0; i--) {
            result.add(result.get(i) | m);
        }
    }

}
