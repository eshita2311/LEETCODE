import java.util.ArrayList;
import java.util.List;

class Solution {
    // Splits a balanced parentheses string into two groups (0 and 1)
    // to minimize the maximum depth of either group.
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] result = new int[n];
        
        // Uses a List to act as a stack tracking assigned groups (0 or 1).
        List<Integer> stack = new ArrayList<>();

        // Iterate through each character in the sequence
        for (int i = 0; i < n; i++) {
            char ch = seq.charAt(i);

            if (ch == '(') {
                // Alternately assign the opening parenthesis to group 0 or 1 
                // based on what the last assigned group was.
                if (stack.isEmpty() || stack.get(stack.size() - 1) == 1) {
                    stack.add(0); // Assign current depth level to group 0
                    result[i] = 0;
                } else {
                    stack.add(1); // Assign current depth level to group 1
                    result[i] = 1;
                }
            } else {
                // Pop the last assigned group to correctly match the 
                // closing parenthesis with its corresponding opening one.
                int remove = stack.remove(stack.size() - 1);
                result[i] = remove;
            }
        }

        return result;
    }
}