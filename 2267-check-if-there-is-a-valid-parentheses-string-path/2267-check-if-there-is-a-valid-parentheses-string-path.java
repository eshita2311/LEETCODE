class Solution {
    int n;
    int m;

    class Record {
        int ind;
        int[] ar;

        Record() {
            ar = new int[m+n];
            ind = 0;
        }

        void add(int val) {
            ar[val] = 1;
        }

    }

    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        Record[][] dp = new Record[m][n];
        //for(int i = 0; i < m; i++)  System.out.println(Arrays.toString(grid[i]));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                dp[i][j] = new Record();
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j] == '(' ? 1 : -1;
                if(i == 0 && j == 0 && val >=0){
                    dp[i][j].add(val);
                    continue;
                }
                if (i != 0) {
                    for (int ind = 0; ind < m+n; ind++) {
                        if(dp[i - 1][j].ar[ind] == 1 && val + ind >=0) 
                            dp[i][j].add(ind + val);
                    }
                }

                if (j != 0) {
                    for (int ind = 0; ind < m+n; ind++) {
                        if(dp[i][j - 1].ar[ind] == 1 && val + ind >=0) 
                            dp[i][j].add(ind + val);
                    }
                }
            }
        }

        return dp[m - 1][n - 1].ar[0] == 1;

    }
}