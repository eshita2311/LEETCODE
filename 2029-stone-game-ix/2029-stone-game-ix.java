class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[]  freq = new int[3];

        // Frequency count
        for(final int val: stones) {
            freq[val % 3]++;
        }

        // Even no. of multiple of 3s, equal distribution
        if((freq[0] & 1) == 0) {
            return freq[1] > 0 && freq[2] > 0;
        }
        
        // 1-1-2 or 1-2-2 pairs, > 2 because if no stones remains after ALice's chance Bob wins
        return Math.abs(freq[1] - freq[2]) > 2;
    }
}