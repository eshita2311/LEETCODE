class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;

        // Case 1: only one subarray
        if (k == n) {
            int max = nums[0];

            for (int num : nums) {
                max = Math.max(max, num);
            }

            return max;
        }

        // Count frequency
        HashMap<Integer, Integer> cnt = new HashMap<>();

        for (int num : nums) {
            cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        }

        // Case 2: every subarray has one element
        if (k == 1) {
            int res = -1;

            for (int num : nums) {
                if (cnt.get(num) == 1) {
                    res = Math.max(res, num);
                }
            }

            return res;
        }

        // Case 3: only first and last elements can qualify
        int res = -1;

        if (cnt.get(nums[0]) == 1) {
            res = Math.max(res, nums[0]);
        }

        if (cnt.get(nums[n - 1]) == 1) {
            res = Math.max(res, nums[n - 1]);
        }

        return res;
    }
}
