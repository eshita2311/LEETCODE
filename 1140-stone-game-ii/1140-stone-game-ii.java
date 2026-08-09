class Solution {
    public int stoneGameII(int[] piles) {
        int len = piles.length;
        int[][] dp = new int[len + 1][len + 1];
        int[] suffixSum = new int[len + 1];
        for (int i = len - 1; i >= 0; i--) suffixSum[i] = suffixSum[i + 1] + piles[i];
        for (int i = 0; i <= len; i++) dp[i][len] = suffixSum[i];
        for (int index = len - 1; index >= 0; index--) {
            for (int maxTillNow = len - 1; maxTillNow >= 1; maxTillNow--) {
                for (int x = 1; x <= 2 * maxTillNow && index + x <= len; x++) dp[index][maxTillNow] = Math.max(dp[index][maxTillNow], suffixSum[index] - dp[index + x][Math.max(maxTillNow, x)]);
            }
        }
        return dp[0][1];
    }
}