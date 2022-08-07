package _20220807_NetworkDelayTime;

import java.util.*;

public class Solution {

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Edge>> graph = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            graph.get(u).add(new Edge(v, w));
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;
        boolean[] visited = new boolean[n + 1];

        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(k, 0));

        while (!queue.isEmpty()) {
            Edge e = queue.poll();
            visited[e.v] = true;
            int distanceToE = distance[e.v];
            for (Edge u : graph.get(e.v)) {
                if (visited[u.v]) continue;
                int distanceToV = distance[u.v];
                int newDistanceToV = distanceToE + u.w;
                if (newDistanceToV < distanceToV) {
                    distance[u.v] = newDistanceToV;
                    if (distanceToV != Integer.MAX_VALUE)
                        queue.remove(new Edge(u.v, distanceToV));
                    queue.add(new Edge(u.v, newDistanceToV));
                }
            }
        }

        int delay = 0;
        for (int i = 1; i <= n; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                return -1;
            }
            delay = Math.max(delay, distance[i]);
        }
        return delay;
    }

    private static class Edge implements Comparable<Edge> {
        int v;
        int w;

        Edge(int v, int w) {
            this.v = v;
            this.w = w;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return v == edge.v && w == edge.w;
        }

        @Override
        public int hashCode() {
            return Objects.hash(v, w);
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(w, o.w);
        }
    }

}
