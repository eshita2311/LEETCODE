class Solution {
    private boolean fn(int stones, boolean alicePlays, int[][] dp) {
        if (stones == 0) {
            return !alicePlays;
        }

        if (dp[stones][alicePlays ? 1 : 0] != -1)
            return dp[stones][alicePlays ? 1 : 0] == 1;

        boolean result = alicePlays ? false : true;

        for (int i = 1; (i * i) <= stones; i++) {
            int remove = i * i;
            boolean current_result = fn(stones - remove, !alicePlays, dp);
            if (alicePlays)
                result = result || current_result;
            else
                result = result && current_result;
        }

        dp[stones][alicePlays ? 1 : 0] = result ? 1 : 0;
        return result;
    }

    public boolean winnerSquareGame(int n) {
        int[][] dp = new int[n + 1][2];
        for (int[] row : dp)
            java.util.Arrays.fill(row, -1);
        return fn(n, true, dp);
    }
}