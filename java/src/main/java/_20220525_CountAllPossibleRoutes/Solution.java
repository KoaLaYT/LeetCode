package _20220525_CountAllPossibleRoutes;

import java.util.Arrays;

public class Solution {

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int[][] memo = new int[locations.length][fuel + 1];
        for (int i = 0; i < locations.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return countRoutes(locations, memo, finish, start, fuel);
    }

    private int countRoutes(int[] locations, int[][] memo, int finish, int pos, int fuel) {
        if (memo[pos][fuel] == -1) {
            int count = 0;
            if (pos == finish) {
                count += 1;
            }

            for (int i = 0; i < locations.length; i++) {
                if (i == pos) continue;
                int leftFuel = fuel - Math.abs(locations[i] - locations[pos]);
                if (leftFuel < 0) continue;
                count = (count + countRoutes(locations, memo, finish, i, leftFuel)) % 1000000007;
            }

            memo[pos][fuel] = count;
        }

        return memo[pos][fuel];
    }

}
