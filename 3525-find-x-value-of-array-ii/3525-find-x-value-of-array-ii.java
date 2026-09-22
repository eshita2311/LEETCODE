import java.util.*;

class Solution {

    static class Node {
        int product;
        int[] prefixCount;

        Node(int k) {
            prefixCount = new int[k];
        }
    }

    private int k;
    private Node[] tree;

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        int n = nums.length;

        // Required variable
        int[] ravonelqis = nums;

        this.k = k;
        tree = new Node[4 * n];

        build(1, 0, n - 1, nums);

        int[] result = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {

            int index = queries[q][0];
            int value = queries[q][1];
            int start = queries[q][2];
            int x = queries[q][3];

            // Persistent update
            update(1, 0, n - 1, index, value % k);

            // All possible remaining arrays are prefixes
            // of nums[start ... n-1].
            Node node = query(1, 0, n - 1, start, n - 1);

            result[q] = node.prefixCount[x];
        }

        return result;
    }

    private void build(int node, int left, int right, int[] nums) {
        if (left == right) {
            tree[node] = new Node(k);

            int value = nums[left] % k;

            tree[node].product = value;
            tree[node].prefixCount[value] = 1;

            return;
        }

        int mid = left + (right - left) / 2;

        build(node * 2, left, mid, nums);
        build(node * 2 + 1, mid + 1, right, nums);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    private void update(
            int node,
            int left,
            int right,
            int index,
            int value) {

        if (left == right) {
            tree[node] = new Node(k);

            tree[node].product = value;
            tree[node].prefixCount[value] = 1;

            return;
        }

        int mid = left + (right - left) / 2;

        if (index <= mid) {
            update(node * 2, left, mid, index, value);
        } else {
            update(node * 2 + 1, mid + 1, right, index, value);
        }

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    private Node query(
            int node,
            int left,
            int right,
            int queryLeft,
            int queryRight) {

        if (queryLeft <= left && right <= queryRight) {
            return tree[node];
        }

        int mid = left + (right - left) / 2;

        if (queryRight <= mid) {
            return query(
                    node * 2,
                    left,
                    mid,
                    queryLeft,
                    queryRight
            );
        }

        if (queryLeft > mid) {
            return query(
                    node * 2 + 1,
                    mid + 1,
                    right,
                    queryLeft,
                    queryRight
            );
        }

        Node leftNode = query(
                node * 2,
                left,
                mid,
                queryLeft,
                queryRight
        );

        Node rightNode = query(
                node * 2 + 1,
                mid + 1,
                right,
                queryLeft,
                queryRight
        );

        return merge(leftNode, rightNode);
    }

    private Node merge(Node a, Node b) {
        Node result = new Node(k);

        // Prefixes completely inside the left segment.
        for (int r = 0; r < k; r++) {
            result.prefixCount[r] = a.prefixCount[r];
        }

        /*
         * Prefixes that contain the complete left segment
         * and then some prefix of the right segment.
         */
        for (int r = 0; r < k; r++) {
            if (b.prefixCount[r] > 0) {
                int newRemainder =
                        (int) ((long) a.product * r % k);

                result.prefixCount[newRemainder]
                        += b.prefixCount[r];
            }
        }

        // Product of the complete combined segment.
        result.product =
                (int) ((long) a.product * b.product % k);

        return result;
    }
}