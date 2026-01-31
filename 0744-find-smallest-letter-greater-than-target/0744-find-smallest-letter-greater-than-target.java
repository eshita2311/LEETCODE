class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length; 
        int st= 0, end=n-1;
        while(st<=end){
            int mid = st + (end-st)/2;
            if(letters[mid]>target){
                end=mid-1;
            }
            else {
                st=mid+1;
            }
        }
        return letters[st%n];
    }
}
public class GreaterLetter{
    public static void main(String args[]){
        char[] letters = {'x','x','y'};
        char target = 'z';
        Solution s = new Solution();
        System.out.println(s.nextGreatestLetter(letters, target));
    }
}