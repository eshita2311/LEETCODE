class Solution {
     public boolean sumGame(String num) {
        int h1 = 0;
        int h2 = 0;
        int q1 = 0;
        int q2 = 0;
        int n = num.length();
        for (int i = 0; i < n / 2; i++) 
            if (num.charAt(i) == '?')
                q1 += 1;
            else
                h1 += (num.charAt(i) - '0');
        for (int i = n / 2; i < n; i++)
            if (num.charAt(i) == '?')
                q2 += 1;
            else
                h2 += (num.charAt(i) - '0');
        if ((q1 + q2) % 2 == 1) // as alice had upper hand 
            return true;
        if (h1 - h2 == (q2 - q1) / 2 * 9) // where the optimla goal is to bring 9 and make them equal
            return false;
        return true;
    }
}