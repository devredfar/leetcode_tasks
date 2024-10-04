package com.sedykh.topological_sort;

import java.util.*;

/**
 * 1462. Course Schedule IV
 * <p>
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array
 * prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course ai first if you want to take
 * course bi.
 * <p>
 * For example, the pair [0, 1] indicates that you have to take course 0 before you can take course 1. Prerequisites can
 * also be indirect. If course a is a prerequisite of course b, and course b is a prerequisite of course c, then course
 * a is a prerequisite of course c.
 * <p>
 * You are also given an array queries where queries[j] = [uj, vj]. For the jth query, you should answer whether course
 * uj is a prerequisite of course vj or not.
 * <p>
 * Return a boolean array answer, where answer[j] is the answer to the jth query.
 */
public class CourseSchedule4 {

    public static class MySolution {

        @SuppressWarnings("unchecked")
        public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
            List<Integer>[] adjustments = new List[numCourses];
            int[] dependencies = new int[numCourses];
            HashMap<Integer, Set<Integer>> indirectPrerequisites = new HashMap<>();
            for (int i = 0; i < adjustments.length; i++) {
                adjustments[i] = new ArrayList<>();
                indirectPrerequisites.put(i, new HashSet<>());
            }
            for (int[] prerequisite : prerequisites) {
                adjustments[prerequisite[0]].add(prerequisite[1]);
                dependencies[prerequisite[1]]++;
                indirectPrerequisites.get(prerequisite[1]).add(prerequisite[0]);
            }
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (dependencies[i] == 0) {
                    queue.add(i);
                }
            }
            while (!queue.isEmpty()) {
                Integer courseNum = queue.poll();
                List<Integer> adjustment = adjustments[courseNum];
                for (int prereq : adjustment) {
                    dependencies[prereq]--;
                    indirectPrerequisites.get(prereq).addAll(indirectPrerequisites.get(courseNum));
                    if (dependencies[prereq] == 0) {
                        queue.add(prereq);
                    }
                }
            }
            ArrayList<Boolean> result = new ArrayList<>();
            for (int[] query : queries) {
                result.add(indirectPrerequisites.get(query[1]).contains(query[0]));
            }
            return result;
        }
    }

    public static class Optimal {
        private List<List<Integer>> adjList;
        private BitSet[] preMap;
        private int[] state;

        public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
            // Initialize adjacency list
            adjList = new ArrayList<>();
            for (int i = 0; i < numCourses; i++) {
                adjList.add(new ArrayList<>());
            }
            // Build the adjacency list
            for (int[] pre : prerequisites) {
                int course = pre[1];
                int prereq = pre[0];
                adjList.get(course).add(prereq);
            }

            // Initialize preMap and state arrays
            preMap = new BitSet[numCourses];
            for (int i = 0; i < numCourses; i++) {
                preMap[i] = new BitSet(numCourses);
            }
            state = new int[numCourses];

            // Precompute all prerequisites for each course
            for (int i = 0; i < numCourses; i++) {
                dfs(i);
            }

            // Answer the queries
            List<Boolean> res = new ArrayList<>();
            for (int[] query : queries) {
                int u = query[0];
                int v = query[1];
                res.add(preMap[v].get(u));
            }

            return res;
        }

        // DFS to find all prerequisites for the given course
        private BitSet dfs(int course) {
            // If already visited, return the cached prerequisites
            if (state[course] == 2) {
                return preMap[course];
            }
            // If currently visiting, a cycle is detected (not expected per problem constraints)
            if (state[course] == 1) {
                return preMap[course]; // Returning empty BitSet to prevent infinite loop
            }

            // Mark as visiting
            state[course] = 1;

            // Traverse all prerequisites
            for (int prereq : adjList.get(course)) {
                // Add the direct prerequisite
                preMap[course].set(prereq);
                // Recursively add all prerequisites of the prerequisite
                preMap[course].or(dfs(prereq));
            }

            // Mark as visited
            state[course] = 2;

            return preMap[course];
        }
    }

}
