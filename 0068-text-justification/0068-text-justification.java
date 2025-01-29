import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            int j = i, lineLength = 0;
            // Find words that fit into the current line
            while (j < words.length && lineLength + words[j].length() + (j - i) <= maxWidth) {
                lineLength += words[j].length();
                j++;
            }

            int numWords = j - i;
            int numSpaces = maxWidth - lineLength;
            StringBuilder line = new StringBuilder();

            // If it's the last line or contains only one word -> left-justify
            if (j == words.length || numWords == 1) {
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1)
                        line.append(" "); // Space between words
                }
                // Fill the remaining spaces to match maxWidth
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            }
            // Otherwise, distribute spaces evenly
            else {
                int spacesBetween = numSpaces / (numWords - 1);
                int extraSpaces = numSpaces % (numWords - 1);

                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) {
                        int spaces = spacesBetween + (extraSpaces > 0 ? 1 : 0);
                        extraSpaces--;
                        for (int s = 0; s < spaces; s++) {
                            line.append(" ");
                        }
                    }
                }
            }

            result.add(line.toString());
            i = j; // Move to the next group of words
        }

        return result;
    }
}
