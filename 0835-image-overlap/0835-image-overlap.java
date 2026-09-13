import java.util.*;

class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;

        List<Integer> ones1 = new ArrayList<>();
        List<Integer> ones2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (img1[i][j] == 1) {
                    ones1.add(i * n + j);
                }

                if (img2[i][j] == 1) {
                    ones2.add(i * n + j);
                }
            }
        }

        int[][] count = new int[2 * n][2 * n];

        int answer = 0;

        for (int a : ones1) {
            int r1 = a / n;
            int c1 = a % n;

            for (int b : ones2) {
                int r2 = b / n;
                int c2 = b % n;

                int dx = r2 - r1 + n;
                int dy = c2 - c1 + n;

                count[dx][dy]++;

                answer = Math.max(
                    answer,
                    count[dx][dy]
                );
            }
        }

        return answer;
    }
}