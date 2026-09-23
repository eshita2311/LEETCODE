class Solution {
    // Define a constant for unmatched target scenarios.
    private static final int NOT_FOUND = -1;

    public int minOperations(int[] nums, int targetSum) {
        int numTot = nums.length;
        
        // 1. Initialize the running sum to the total array sum.
        long currSum = 0;
        for (int num : nums) {
            currSum += num;
        }
        
        int minOpCnt = -1;
        int lIdx = 0;

        for (int rIdx = 0; rIdx < numTot; ++rIdx) {
            // 2. Shrink the right side of the suffix to reduce the sum.
            currSum -= nums[rIdx];

            // 3. Expand the prefix from the left if the sum falls below the target.
            while (currSum < targetSum && lIdx <= rIdx) {
                currSum += nums[lIdx];
                ++lIdx;
            }

            // 4. Update the minimum operations when the exact target sum is achieved.
            if (currSum == targetSum) {
                int currOpCnt = numTot - rIdx - 1 + lIdx;
                if (minOpCnt == -1 || currOpCnt < minOpCnt) {
                    minOpCnt = currOpCnt;
                }
            }
        }

        // 5. Cast the optional result or return the not-found sentinel.
        return minOpCnt == -1 ? NOT_FOUND : minOpCnt;
    }
}