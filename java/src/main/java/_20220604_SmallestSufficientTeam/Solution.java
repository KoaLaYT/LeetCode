package _20220604_SmallestSufficientTeam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int[] skills = convertToBitMaskSkills(req_skills, people);

        long[] dp = new long[1 << req_skills.length];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        int maxSize = skills[0];

        for (int i = 0; i < people.size(); i++) {
            if (skills[i] == 0) continue;
            for (int j = 0; j <= maxSize; j++) {
                if (dp[j] == -1) continue;
                int fulfilled = skills[i] | j;
                if (fulfilled == j) continue;
                if (size(dp[fulfilled]) > size(dp[j]) + 1) {
                    dp[fulfilled] = dp[j] | (1L << i);
                }
            }
            maxSize |= skills[i];
        }

        long team = dp[(1 << req_skills.length) - 1];

        return convertBitMaskBack(team);
    }

    private int[] convertBitMaskBack(long team) {
        int[] res = new int[Long.bitCount(team)];
        int i = 0;
        int j = 0;
        while (team > 0) {
            boolean selected = (team & 1) > 0;
            if (selected) {
                res[i++] = j;
            }
            j += 1;
            team >>= 1;
        }
        return res;
    }

    private int[] convertToBitMaskSkills(String[] req_skills, List<List<String>> people) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < req_skills.length; i++) {
            map.put(req_skills[i], i);
        }

        int[] skills = new int[people.size()];
        for (int i = 0; i < people.size(); i++) {
            for (int j = 0; j < people.get(i).size(); j++) {
                skills[i] |= 1 << map.get(people.get(i).get(j));
            }
        }

        return skills;
    }

    private int size(long team) {
        return Long.bitCount(team);
    }

}
