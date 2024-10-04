package com.sedykh.topological_sort;

import java.util.*;

/**
 * 207. Course Schedule
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates
 * that you must take course bi first if you want to take course ai.
 * <p>
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 */
public class CourseSchedule {

    //DFS
    public static class DFSNaive {

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            List<Set<Integer>> list = new ArrayList<>();
            Set<Integer> queue1 = new HashSet<>();
            Set<Integer> queue2 = new HashSet<>();
            for (int i = 0; i < numCourses; i++) {
                list.add(new HashSet<>());
                queue1.add(i);
            }
            if (prerequisites.length == 0) {
                return true;
            }
            for (int[] prerequisite : prerequisites) {
                list.get(prerequisite[0]).add(prerequisite[1]);
            }
            HashSet<Integer> learnedCourses = new HashSet<>();
            boolean changed = true;
            var queue = queue1;
            var queueNext = queue2;
            while (!queue.isEmpty() && changed) {
                changed = false;
                for (Integer course : queue) {
                    Set<Integer> requirementCourses = list.get(course);
                    requirementCourses.removeAll(learnedCourses);
                    if (requirementCourses.isEmpty()) {
                        learnedCourses.add(course);
                        changed = true;
                    } else {
                        queueNext.addAll(requirementCourses);
                        queueNext.add(course);
                    }
                }
                queue = queueNext;
                queueNext = new HashSet<>();
            }
            return queue.isEmpty();
        }
    }

    public static class TopologicalSort {

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            ArrayList<ArrayList<Integer>> nodes = new ArrayList<>();
            for (int i = 0; i < numCourses; i++) {
                nodes.add(new ArrayList<>());
            }
            int[] countOfDependenciesOnCourse = new int[numCourses];

            for (int[] prerequisite : prerequisites) {
                nodes.get(prerequisite[0]).add(prerequisite[1]);
                countOfDependenciesOnCourse[prerequisite[1]]++;
            }

            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (countOfDependenciesOnCourse[i] == 0) {
                    q.add(i);
                }
            }

            List<Integer> learnedCourses = new ArrayList<>();
            // o(v + e)
            while (!q.isEmpty()) {
                int node = q.poll();
                learnedCourses.add(node);

                for (int dependencyCourse : nodes.get(node)) {
                    countOfDependenciesOnCourse[dependencyCourse]--;
                    if (countOfDependenciesOnCourse[dependencyCourse] == 0) {
                        q.add(dependencyCourse);
                    }
                }
            }
            return learnedCourses.size() == numCourses;
        }
    }
}
