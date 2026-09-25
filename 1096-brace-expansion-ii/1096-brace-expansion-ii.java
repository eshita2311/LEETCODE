class Solution {
    public List<String> braceExpansionII(String expression) {
        Set<String> set = expand(expression);
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        return list;
    }

    private Set<String> expand(String s) {
        Set<String> res = new HashSet<>();
        StringBuilder builder = new StringBuilder();

        int i = 0;
        for(; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '{') break;
            builder.append(c);
        }

        if(i == s.length()) {
            res.add(builder.toString());
            return res;
        }

        Set<String> subset1 = new HashSet<>();
        int count = 0;
        int start = i + 1;
        for(; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '{') count++;
            else if(c == '}') count--;
            if(count == 0) break;
        }

        count = 0;
        for(int k = start; k < i; k++) {
            char c = s.charAt(k);
            if(c == '{') count++;
            if(c == '}') count--;
            if(c == ',' && count == 0) {
                subset1.addAll(expand(s.substring(start, k)));
                start = k + 1;
            } 
        }
        if(start < i) {
            subset1.addAll(expand(s.substring(start, i)));
        }

        i++;
        if(i == s.length()) {
            int curLen = builder.length();
            for(String ss : subset1) {
                builder.append(ss);
                res.add(builder.toString());
                builder.setLength(curLen);
            }
            return res;
        }

        Set<String> subset2 = expand(s.substring(i));
        int len1 = builder.length();
        for(String s1 : subset1) {
            builder.append(s1);
            int len2 = builder.length();
            for(String s2 : subset2) {
                builder.append(s2);                
                res.add(builder.toString());
                builder.setLength(len2);
            }
            builder.setLength(len1);
        }

        return res;
    }
}