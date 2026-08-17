class Solution {
    int n;
    int[][] t = new int[501][501];

    int solve(int left, int right, int[] prefixSum) {
        if (left >= right)
            return 0;

        if (t[left][right] != -1) {
            return t[left][right];
        }

        int leftsum = 0;
        int rightsum = 0;
        int score = 0;

        for (int mid = left; mid < right; mid++) {
            leftsum = prefixSum[mid + 1] - prefixSum[left];
            rightsum = prefixSum[right + 1] - prefixSum[mid + 1];

            if (leftsum < rightsum) {
                score = Math.max(
                    score,
                    leftsum + solve(left, mid, prefixSum)
                );
            }
            else if (leftsum > rightsum) {
                score = Math.max(
                    score,
                    rightsum + solve(mid + 1, right, prefixSum)
                );
            }
            else {
                score = Math.max(
                    score,
                    Math.max(
                        leftsum + solve(left, mid, prefixSum),
                        rightsum + solve(mid + 1, right, prefixSum)
                    )
                );
            }
        }

        return t[left][right] = score;
    }

    public int stoneGameV(int[] nums) {
        n = nums.length;

        for (int[] row : t) {
            java.util.Arrays.fill(row, -1);
        }

        int[] prefixSum = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        return solve(0, n - 1, prefixSum);
    }
}