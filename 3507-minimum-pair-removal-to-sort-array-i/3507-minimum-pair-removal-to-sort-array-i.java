class Solution {
    public int minimumPairRemoval(int[] nums) {
        int operations = 0;

        while (!isNonDecreasing(nums)) {

            int minSum = Integer.MAX_VALUE;
            int idx = 0;

            // find leftmost adjacent pair with minimum sum
            for (int i = 0; i < nums.length - 1; i++) {
                int sum = nums[i] + nums[i + 1];
                if (sum < minSum) {
                    minSum = sum;
                    idx = i;
                }
            }

            // create new array with size - 1
            int[] next = new int[nums.length - 1];
            int k = 0;

            for (int i = 0; i < nums.length; i++) {
                if (i == idx) {
                    next[k++] = nums[i] + nums[i + 1];
                    i++; // skip the next element (merged)
                } else {
                    next[k++] = nums[i];
                }
            }

            nums = next;
            operations++;
        }

        return operations;
    }

    private boolean isNonDecreasing(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }
}