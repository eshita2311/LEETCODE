class Solution {

    public String evaluate(String s, List<List<String>> knowledge) {

        // Store key-value pairs in a HashMap for fast lookup
        Map<String, String> knowledgeMap = new HashMap<>(knowledge.size());

        for (List<String> pair : knowledge) {
            knowledgeMap.put(pair.get(0), pair.get(1));
        }

        // Build the final result
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {

                // Find the closing bracket
                int closingBracketIndex = s.indexOf(')', i + 1);

                // Extract the key
                String key = s.substring(i + 1, closingBracketIndex);

                // Replace with value, or '?' if key is absent
                result.append(knowledgeMap.getOrDefault(key, "?"));

                // Skip to the closing bracket
                i = closingBracketIndex;

            } else {
                // Append normal characters
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}