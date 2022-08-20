package _20220820_CourseScheduleII;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

public class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return new int[]{};
        }

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] ins = new int[numCourses];

        for (int[] prerequest : prerequisites) {
            int u = prerequest[1];
            int v = prerequest[0];
            graph.get(u).add(v);
            ins[v] += 1;
        }

        PriorityQueue<In> queue = new PriorityQueue<>();
        for (int i = 0; i < numCourses; i++) {
            queue.add(new In(ins[i], i));
        }

        int[] result = new int[numCourses];
        int i = 0;

        while (i < numCourses) {
            In first = queue.poll();

            if (first.num != 0) {
                return new int[]{};
            }

            result[i++] = first.course;
            for (int v : graph.get(first.course)) {
                ins[v] -= 1;
                In in = new In(ins[v], v);
                queue.remove(in);
                queue.add(in);
            }
        }

        return result;
    }

    private static class In implements Comparable<In> {
        int num;
        int course;

        In(int num, int course) {
            this.num = num;
            this.course = course;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            In in = (In) o;
            return course == in.course;
        }

        @Override
        public int hashCode() {
            return Objects.hash(course);
        }

        @Override
        public int compareTo(In o) {
            return Integer.compare(num, o.num);
        }
    }

}
