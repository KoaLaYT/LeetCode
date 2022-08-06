package _20220806_TreeSplit;

public class Solution {

    public int tree_split(int[][] childs) {
        int[] memo = new int[childs.length];
        return dfs(childs, 0, memo);
    }

    private int dfs(int[][] childs, int node, int[] memo) {
        if (childs[node].length == 0) {
            return 1;
        }
        if (memo[node] != 0) {
            return memo[node];
        }

        int result = 1;
        for (int subChild : childs[node]) {
            int cost1 = 0;
            int cost2 = 0;
            cost2 += dfs(childs, subChild, memo);
            for (int subSubChild : childs[subChild]) {
                cost1 += dfs(childs, subSubChild, memo);
            }
            result += Math.min(cost1, cost2);
        }
        return memo[node] = result;
    }

}
