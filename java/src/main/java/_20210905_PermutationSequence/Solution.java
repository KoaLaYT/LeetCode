package _20210905_PermutationSequence;

import java.util.LinkedList;

/**
 * @author koalayt 2021-09-05
 */
public class Solution {

    public String getPermutation(int n, int k) {
        LinkedList<Integer> list = initList(n);
        StringBuilder stringBuilder = new StringBuilder();

        while (!list.isEmpty()) {
            if (k == 0) {
                // shortcut
                stringBuilder.append(list.removeLast());
                continue;
            }

            int factor = factorial(list.size() - 1);
            int divider = k / factor;
            k %= factor;
            if (k > 0) {
                divider += 1;
            }
            int number = list.remove(divider - 1);
            stringBuilder.append(number);
        }

        return stringBuilder.toString();
    }

    private LinkedList<Integer> initList(int n) {
        LinkedList<Integer> result = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            result.addLast(i + 1);
        }
        return result;
    }

    private int factorial(int n) {
        int result = 1;
        while (n > 1) {
            result *= n--;
        }
        return result;
    }

}
