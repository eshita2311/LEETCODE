class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int xor = 0;
        boolean flag = false;
        for(int i: nums){
            if(i>0) flag = true;
            xor=xor^i;
        }

        if(!flag) return 0 ;
        if(xor>0) return n;

        return n-1;
    }
}