package _20220723_IsBipartite;

public class Solution {

    public boolean isBipartite(int[][] graph) {
        //  0 - uncolored
        //  1 - black
        // -1 - white
        int[] visited = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (visited[i] != 0) continue;
            boolean result = dfs(graph, visited, i, 1);
            if (!result) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int[][] graph, int[] visited, int v, int color) {
        if (visited[v] == color) {
            return true;
        }

        if (visited[v] != 0 && visited[v] != color) {
            return false;
        }

        visited[v] = color;

        for (int u : graph[v]) {
            boolean result = dfs(graph, visited, u, color * (-1));
            if (!result) {
                return false;
            }
        }

        return true;
    }

}
