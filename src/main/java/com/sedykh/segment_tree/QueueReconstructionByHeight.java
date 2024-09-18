package com.sedykh.segment_tree;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * You are given an array of people, people, which are the attributes of some people
 * in a queue (not necessarily in order). Each people[i] = [hi, ki] represents
 * the ith person of height hi with exactly ki other people in front who have a height
 * greater than or equal to hi.
 * <p>
 * Reconstruct and return the queue that is represented by the input array people.
 * The returned queue should be formatted as an array queue, where queue[j] = [hj, kj]
 * is the attributes of the jth person in the queue (queue[0] is the person at the front of the queue).
 */
public class QueueReconstructionByHeight {
    public int[][] reconstructQueueNaive(int[][] people) {
        Arrays.sort(people, (arr1, arr2) -> arr1[0] == arr2[0] ?
                arr1[1] - arr2[1] :
                arr2[0] - arr1[0]);
        ArrayList<int[]> result = new ArrayList<>();
        for (int[] person : people) {
            result.add(person[1], person);
        }
        return result.toArray(new int[people.length][2]);
    }

    class SegmentTree {
        private int N;
        private final int[] node;
        SegmentTree(int n) {
            // N = Round up n to the next highest power of 2 (i.e. N = 1 for n = 1; N = 2 for n = 2; N = 4 for n = 3, 4; N = 8 for n = 5, 6, 7, 8; and so on)
            N = 1;
            while(N < n) {
                N <<= 1;
            }
            node = new int[(N << 1) - 1];  // total no of nodes in the tree: 2*N-1
            for(int i = 0; i < n; i++) {  // leaf nodes: initialize each with 1 available spot
                node[N - 1 + i] = 1;
            }
            for(int i = N - 2; i >= 0; i--) {  // internal nodes: calculate available spots as sum of available spots in child nodes
                node[i] = node[(i<<1) + 1] + node[(i<<1) + 2];  // left child: 2*i+1, right child: 2*i+2
            }
        }
        public int insert(int k) { // return the index of k'th 1 and make it 0
            int i = 0; // root node
            while(i < N - 1) {  // internal nodes
                node[i]--;  // decrement available spots by 1 as we go down towards leaf node
                int left = (i<<1) + 1;
                if(node[left] > k) {  // decide whether to go to left child or to right child based on available spots in them
                    i = left;
                } else {
                    i = left + 1;  // left + 1 means right
                    k -= node[left];  // if going to right child, reduce k by the no of available spots in left child
                }
            }
            node[i]--;  // this is the target leaf node: make 1 to 0
            return i - N + 1;  // convert to the index that caller expects; leaf nodes begin at N-1
        }
    }
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);  // compare (h, k) by h; in case of ties, compare k in reverse order
        int n = people.length;
        SegmentTree st = new SegmentTree(n);
        int[][] res = new int[n][];
        for(int[] p: people) {
            res[st.insert(p[1])] = p;  // place p at the index of the k'th available spot returned by segment tree
        }
        return res;
    }
}