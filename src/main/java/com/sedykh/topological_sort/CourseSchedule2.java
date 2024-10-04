package com.sedykh.topological_sort;

import java.util.*;

/**
 * 210. Course Schedule II
 * <p>
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
 * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take courseNum bi
 * first if you want to take courseNum ai.
 * <p>
 * For example, the pair [0, 1], indicates that to take courseNum 0 you have to first take courseNum 1. Return the
 * ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it
 * is impossible to finish all courses, return an empty array.
 */
public class CourseSchedule2 {

    public static class MySolution {

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            var result = new ArrayList<Integer>();
            TreeNode[] courses = new TreeNode[numCourses];

            for (int i = 0; i < courses.length; i++) {
                if (courses[i] == null) {
                    courses[i] = new TreeNode(i, new HashSet<>());
                }
            }

            for (int[] requirement : prerequisites) {
                int courseNum = requirement[0];
                int requiredCourse = requirement[1];
                courses[courseNum].requirements.add(requiredCourse);
            }

            Queue<TreeNode> queue = new LinkedList<>();
            for (int i = 0; i < courses.length; i++) {
                if (courses[i].requirements.isEmpty()) {
                    queue.add(courses[i]);
                    result.add(i);
                }
            }

            while (!queue.isEmpty()) {
                TreeNode finishedCourse = queue.poll();
                for (TreeNode unfinishedCourse : courses) {
                    if (unfinishedCourse.requirements.remove(finishedCourse.courseNum)) {
                        if (unfinishedCourse.requirements.isEmpty()) {
                            queue.add(unfinishedCourse);
                            result.add(unfinishedCourse.courseNum);
                        }
                    }
                }
            }
            if (result.size() != numCourses) {
                return new int[]{};
            }

            return result.stream().
                mapToInt(x -> x).
                toArray();
        }

        private record TreeNode(int courseNum, Set<Integer> requirements) {

        }
    }

    public static class MySolutionTopologicalSort {

        @SuppressWarnings("unchecked")
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            List<Integer>[] courses = new List[numCourses];
            int[] frequency = new int[numCourses];
            int count = numCourses - 1;

            for (int[] requirement : prerequisites) {
                int courseNum = requirement[0];
                if (courses[courseNum] == null) {
                    courses[courseNum] = new ArrayList<>();
                }
                int requiredCourse = requirement[1];
                courses[courseNum].add(requiredCourse);
                frequency[requiredCourse]++;
            }

            final int[] result = new int[numCourses];
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < courses.length; i++) {
                if (frequency[i] == 0) {
                    queue.add(i);
                    result[count--] = i;
                }
            }

            while (!queue.isEmpty()) {
                List<Integer> requirementsForFinishedCourse = courses[queue.poll()];
                if (requirementsForFinishedCourse != null) {
                    for (final int requiredCourse : requirementsForFinishedCourse) {
                        frequency[requiredCourse]--;
                        if (frequency[requiredCourse] == 0) {
                            queue.add(requiredCourse);
                            result[count--] = requiredCourse;
                        }
                    }
                }
            }
            return count == -1 ? result : new int[0];
        }
    }

    public static class LeetcodeSolution {

        @SuppressWarnings("unchecked")
        public int[] findOrder(final int numCourses, final int[][] prerequisites) {
            final List<Integer>[] courses = new List[numCourses];
            final int[] dependenciesOnCourseCount = new int[numCourses];
            var result = new ArrayList<Integer>();

            for (int[] prerequisite : prerequisites) {
                int courseNum = prerequisite[0];
                if (courses[courseNum] == null) {
                    courses[courseNum] = new ArrayList<>();
                }
                int requiredCourse = prerequisite[1];
                courses[courseNum].add(requiredCourse);
                dependenciesOnCourseCount[requiredCourse]++;
            }

            final Queue<Integer> queue = new LinkedList<>();

            for (int i = 0; i < numCourses; ++i) {
                if (dependenciesOnCourseCount[i] == 0) {
                    result.add(i);
                    queue.offer(i);
                }
            }

            while (!queue.isEmpty()) {
                final int finishedCourseNum = queue.poll();
                List<Integer> dependenciesForCourse = courses[finishedCourseNum];
                for (int i = 0; dependenciesForCourse != null && i < dependenciesForCourse.size(); ++i) {
                    final int p = dependenciesForCourse.get(i);

                    dependenciesOnCourseCount[p]--;

                    if (dependenciesOnCourseCount[p] == 0) {
                        result.add(p);
                        queue.offer(p);
                    }
                }
            }

            if (result.size() != numCourses) {
                return new int[]{};
            }

            Collections.reverse(result);
            return result.stream().
                mapToInt(x -> x).
                toArray();
        }
    }
}
