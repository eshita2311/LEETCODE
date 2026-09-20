class Solution {

    public int reverseDegree(String s) {

        // Stores the total reverse degree of the string.
        int reverseDegree = 0;

        // Traverse each character in the string.
        for (int currentIndex = 0;
             currentIndex < s.length();
             currentIndex++) {

            char currentCharacter = s.charAt(currentIndex);

            /*
             * Calculate the character's position
             * in the reversed alphabet:
             *
             * a = 26
             * b = 25
             * ...
             * z = 1
             */
            int reverseAlphabetValue =
                    26 - (currentCharacter - 'a');

            // String positions are 1-indexed.
            int stringPosition = currentIndex + 1;

            // Add the weighted value of the current character.
            reverseDegree +=
                    reverseAlphabetValue * stringPosition;
        }

        return reverseDegree;
    }
}