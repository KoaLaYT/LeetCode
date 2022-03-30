package _20220330_MaximumLengthOfPairChain;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(p -> p[1]));
        int res = 1;
        int tmp = pairs[0][1];

        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > tmp) {
                res++;
                tmp = pairs[i][1];
            }
        }

        return res;
    }

}
