class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long totalSum = 0;
        int min = n;
        Map<Integer, Integer> pSum = new HashMap<>();
        pSum.put(0, -1);
        for(int k : nums)totalSum += k;
        int mod = (int) (totalSum % p);
        if(mod == 0) return 0;
        long sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            int curMod = (int) (sum % p);
            int targetMod = (curMod + p - mod) % p;
            if(pSum.containsKey(targetMod)) min = Math.min(min, i - pSum.get(targetMod));
            pSum.put(curMod, i);
        }
        return min == n ? -1 : min;
    }
}