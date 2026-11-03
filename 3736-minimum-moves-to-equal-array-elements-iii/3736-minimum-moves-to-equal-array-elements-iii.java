class Solution {
    public int minMoves(int[] nums) {
        int mx = nums[0];
        int ans = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > mx) {
                ans += i * (nums[i] - mx);
                mx = nums[i];
            } else {
                ans += mx - nums[i];
            }
        }
        return ans;
    }
}