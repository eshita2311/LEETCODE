class Solution {
    int[][] dp;
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events,(a,b)->Integer.compare(a[0],b[0]));
        dp = new int[100001][3];
        for(int i = 0 ; i < dp.length ; i++){
            for(int j = 0 ; j < dp[0].length ; j++){
                dp[i][j] = -1;
            }
        }
        int ans = solve(events,0,0);
        return ans;
    }
    private int solve(int[][] e,int idx,int count){
        if(count == 2 || idx >= e.length){
            return 0;
        }
        if(dp[idx][count] != -1)return dp[idx][count];
        int id = bs(e,e[idx][1]);
        int take = e[idx][2] + solve(e,id,count + 1);
        int skip = solve(e,idx+1,count);
        return dp[idx][count] = Math.max(skip,take);
    }
    private int bs(int[][] e,int v){
        int st = 0;
        int ed = e.length-1;
        int ans = e.length;
        while(st <= ed){
            int mid = st + (ed-st)/2;
            if(v < e[mid][0]){
                ans = mid;
                ed = mid - 1;
            }else{
                st = mid + 1;
            }
        }
        return ans;
    }
}