class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int cnt = 0;
        boolean flg = true;

        for (int i : arr1) {
            flg = true;
            for (int j : arr2) {
                if (Math.abs(i - j) <= d) {
                    flg = false;
                }
            }

            cnt += flg ? 1 : 0;
        }

        return cnt;
    }
}