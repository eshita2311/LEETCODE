class Solution {
    public int smallestNumber(int n, int t) {
        int i = n;
        while(!check(i, t)){
            i++;
        }
        return i;
    }
    private boolean check(int n, int t){
        int product = 1;
        while(n > 0){
            int r = n % 10;
            if(r == 0) return true;
            product *= r;
            n = n/ 10;
        }
        return (product % t == 0);
    }
}