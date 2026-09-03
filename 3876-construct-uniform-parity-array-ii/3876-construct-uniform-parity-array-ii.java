class Solution {
    public boolean uniformArray(int[] nums1) {

        // Store the smallest even and odd numbers
        int minOdd = Integer.MAX_VALUE;
        int minEven = Integer.MAX_VALUE;

        // Find the minimum value of each parity
        for (int num : nums1) {

            if (num % 2 == 0) {
                // Even number
                minEven = Math.min(minEven, num);
            } else {
                // Odd number
                minOdd = Math.min(minOdd, num);
            }
        }

        // The only impossible case:
        // an even number exists that is smaller than
        // every odd number.
        if (minEven < minOdd && minOdd != Integer.MAX_VALUE) {
            return false;
        }

        // Otherwise, the array can be made uniform
        return true;
    }
}