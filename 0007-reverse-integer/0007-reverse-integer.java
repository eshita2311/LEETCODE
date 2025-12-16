class Solution {
    public int reverse(int num) {
        long rev=0;
        while(num!=0){
            rev=(rev*10)+(num%10);
            num/=10;
        }
        if(rev>Integer.MAX_VALUE || rev<Integer.MIN_VALUE) return 0;
        return (int)rev;
    }
}