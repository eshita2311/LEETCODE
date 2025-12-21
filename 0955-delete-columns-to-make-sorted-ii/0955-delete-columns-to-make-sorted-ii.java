class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        boolean[] sorted = new boolean[n - 1];
        int count = 0;
        for (int col = 0; col < m; col++) {
            boolean needDelete = false;
            for (int i = 0; i < n - 1; i++) {
                if (!sorted[i]) {
                    char a = strs[i].charAt(col);
                    char b = strs[i + 1].charAt(col);
                    if (a > b) {
                        needDelete = true;
                        break;
                    }
                }
            }
            if (needDelete) {
                count++;
                continue;
            }
            for (int i = 0; i < n - 1; i++) {
                if (!sorted[i]) {
                    char a = strs[i].charAt(col);
                    char b = strs[i + 1].charAt(col);
                    if (a < b) {
                        sorted[i] = true;
                    }
                }
            }
        }
        return count;
    }
}