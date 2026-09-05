class Solution {

    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        int ansIdx = 0;
        int globalMax = Integer.MIN_VALUE;
        int ansMax = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            globalMax = Math.max(globalMax, nums[i]);

            // Update the maximum for the current candidate
            if (i == ansIdx) {
                ansMax = Math.max(ansMax, nums[i]);
            }

            // Current candidate is invalid
            if (nums[i] < ansMax - k) {
                ansIdx = i + 1;
                ansMax = globalMax;
            }
        }

        return ansIdx < n ? ansIdx : -1;
    }
}