class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # Initialize a set to store characters in the current window
        char_set = set()
        # Initialize left pointer and max_length to track the longest substring
        left = 0
        max_length = 0

        # Iterate with the right pointer over the string
        for right in range(len(s)):
            # If the character is in the set, shrink the window by moving left
            while s[right] in char_set:
                char_set.remove(s[left])
                left += 1
            # Add the current character to the set
            char_set.add(s[right])
            # Update the max length of the substring found
            max_length = max(max_length, right - left + 1)

        return max_length
