class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int ans[]=new int[nums.size()];
        for(int i=0;i<nums.size();i++){
            int val=nums.get(i);
            int j=0;
            for(j=0;j<1000;j++){
                if((j|(j+1))==val){
                    ans[i]=j;
                    break;
                }
            }
            if(j==1000){
                ans[i]=-1;
            }
        }
        return ans;
    }
}