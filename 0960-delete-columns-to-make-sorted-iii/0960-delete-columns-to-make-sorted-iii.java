class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();

        int[] dp = new int[m];
        Arrays.fill(dp,1);
        int maxKeep = 1;
        for(int i =0; i<m; i++){
            for(int j=0; j<i; j++){
                boolean valid = true;
                for(int row=0; row<n; row++){
                    if(strs[row].charAt(i)<strs[row].charAt(j)){
                        valid = false;
                        break;
                    }
                }
                if(valid){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            maxKeep = Math.max(maxKeep, dp[i]);
        }
        return m - maxKeep;
    }
}
/*
Row 0: a b g
Row 1: b a f  
Row 2: c a e 
*/