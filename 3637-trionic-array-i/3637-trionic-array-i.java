class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        int i = 1;
        boolean first = false, second = false;

        while (i < n) {
            if (!first) {
                if (nums[i] > nums[i - 1]) {
                    i++;
                } else if (nums[i] < nums[i - 1] && i > 1) {
                    first = true;
                    i++;
                } else {
                    return false;
                }
            } 
            else if (!second) {
                if (nums[i] < nums[i - 1]) {
                    i++;
                } else if (nums[i] > nums[i - 1] && i > 2) {
                    second = true;
                    i++;
                } else {
                    return false;
                }
            } 
            else {
                if (nums[i] > nums[i - 1]) {
                    i++;
                } else {
                    return false;
                }
            }
        }
        return second;
    }
}