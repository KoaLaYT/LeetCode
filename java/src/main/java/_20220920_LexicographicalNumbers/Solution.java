package _20220920_LexicographicalNumbers;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>(n);

        lexicalOrder(n, 1, 1, result);

        return result;
    }

    private void lexicalOrder(
            int n,
            int num,
            int digit,
            List<Integer> result
    ) {
        if (num > n) {
            return;
        }

        result.add(num);
        lexicalOrder(n, num * 10, 0, result);

        if (digit >= 9) {
            return;
        }

        num += 1;
        lexicalOrder(n, num, digit + 1, result);
    }

}
