class Solution {

    int balance(String s) {
        int b = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') b++;
            else if (c == ')') b--;

            if (b < 0) return -1;
        }

        return b;
    }

    public List<String> removeInvalidParentheses(String s) {

        Set<String> vis = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        List<String> ans = new ArrayList<>();

        q.offer(s);

        while (!q.isEmpty()) {

            int size = q.size();
            boolean found = false;

            while (size-- > 0) {

                String curr = q.poll();

                if (vis.contains(curr))
                    continue;

                vis.add(curr);

                if (balance(curr) == 0) {
                    ans.add(curr);
                    found = true;
                }

                if (found)
                    continue;

                for (int i = 0; i < curr.length(); i++) {
                    String next =
                        curr.substring(0, i) +
                        curr.substring(i + 1);

                    q.offer(next);
                }
            }

            if (found)
                return ans;
        }

        return new ArrayList<>();
    }
}