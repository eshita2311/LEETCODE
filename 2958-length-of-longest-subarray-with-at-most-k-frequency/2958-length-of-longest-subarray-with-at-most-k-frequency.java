class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        if(k==nums.length) return k;
        Map<Integer,Integer> map = new HashMap<>();
        int i=0,j=0;
        int ans=0;
        while(i<nums.length){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
            int a = map.get(nums[i]);
            if(a>k){
                ans= Math.max(ans,i-j);
                while(nums[j] != nums[i]){
                    map.put(nums[j],map.get(nums[j])-1);
                    j++;
                }
                map.put(nums[j],map.get(nums[j])-1);
                j++;
            }
            i++;
        }
        return Math.max(ans,i-j);

    }
}