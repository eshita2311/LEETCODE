class Solution {
    public int maximumLengthSubstring(String s) {

        int maxLength = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {

            int start = i;
            HashMap<Character, Integer> map = new HashMap<>();
            int len = 0;

            while (start < n) {
                char ch = s.charAt(start++);

                if (!map.containsKey(ch)) {
                    map.put(ch, 1);
                    len++;
                }

                else if (map.get(ch) < 2) {
                    map.put(ch, map.get(ch) + 1);
                    len++;
                }

                else {
                    break;
                }
            }

            maxLength = Math.max(maxLength, len);
        }

        return maxLength;
    }
}