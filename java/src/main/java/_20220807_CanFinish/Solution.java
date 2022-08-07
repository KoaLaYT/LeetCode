package _20220807_CanFinish;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int[] ins = new int[numCourses];

        for (int[] prerequisit : prerequisites) {
            int u = prerequisit[0];
            int v = prerequisit[1];
            graph.get(u).add(v);
            ins[v] += 1;
        }

        Queue<Integer> canStudyCourses = new ArrayDeque<>();
        for (int course = 0; course < numCourses; course++) {
            if (ins[course] == 0) {
                canStudyCourses.add(course);
            }
        }

        int leftCourse = numCourses;
        while (!canStudyCourses.isEmpty()) {
            int course = canStudyCourses.poll();
            leftCourse -= 1;
            for (int nextCourse : graph.get(course)) {
                ins[nextCourse] -= 1;
                if (ins[nextCourse] == 0) {
                    canStudyCourses.add(nextCourse);
                }
            }
        }

        return leftCourse == 0;
    }

}
