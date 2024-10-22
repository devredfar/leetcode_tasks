package com.sedykh;

import com.sedykh.graphs.Node;
import org.junit.jupiter.api.Assertions;

import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;

public class TestUtils {

    private static final String SEPARATOR_REGEX = "], ?\\[";

    private TestUtils() {
    }

    public static <T> void containsAllInAnyOrder(List<List<T>> actual, List<List<T>> expected) {
        for (List<T> expectedSubList : expected) {
            assertThat("Actual should contain sublist: " + expectedSubList + ", but contains: " + actual,
                actual, hasItem(equalTo(expectedSubList)));
        }
    }

    public static <T> void equalsInAnyOrder(List<List<T>> actual, List<List<T>> expected) {
        containsAllInAnyOrder(actual, expected);
        containsAllInAnyOrder(expected, actual);
    }

    public static ArrayList<List<Integer>> parseToList(String str) {
        String[] subStrs = splitStringToParts(str);

        ArrayList<List<Integer>> result = new ArrayList<>();
        for (String subStr : subStrs) {
            if (subStr.isEmpty()) {
                result.add(new ArrayList<>()); // add new empty list if substring is empty
                continue;
            }
            List<Integer> list = Arrays.stream(subStr.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
            result.add(list);
        }

        return result;
    }

    private static String[] splitStringToParts(String str) {
        str = str.trim();
        String[] split = str.split(SEPARATOR_REGEX);
        split[0] = split[0] != null
            ? split[0].replaceAll("\\[", "")
            : null;
        split[split.length - 1] = split[split.length - 1] != null
                ? split[split.length - 1].replaceAll("]", "")
            : null;
        return split;
    }

    public static int[][] parseToArray2dArray(String input) {
        // Removes surrounding brackets
        String[] parts = splitStringToParts(input);
        int[][] result = new int[parts.length][];

        for (int i = 0; i < parts.length; i++) {
            // Removes potential brackets at the start/end of string
            String[] numbers = parts[i].split(",");
            result[i] = new int[numbers.length];

            for (int j = 0; j < numbers.length; j++) {
                result[i][j] = Integer.parseInt(numbers[j]);
            }
        }

        return result;
    }

    public static void assertEquals(Node node1, Node node2) {
        Set<Node> visited1 = new HashSet<>();
        Set<Node> visited2 = new HashSet<>();

        Assertions.assertEquals(dfs(node1, visited1), dfs(node2, visited2), "Graphs are not equal");
    }

    private static List<Node> dfs(Node node, Set<Node> visited) {
        visited.add(node);

        for (Node neighbor : node.neighbors) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited);
            }
        }

        return new ArrayList<>(visited);
    }
}