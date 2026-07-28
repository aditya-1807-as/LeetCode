class Solution {
    public String smallestPalindrome(String s) {

        int[] freq = new int[26];

        // Count frequency of each character
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        StringBuilder firstHalf = new StringBuilder();
        char middle = 0;

        // Build lexicographically smallest first half
        for (int i = 0; i < 26; i++) {

            // Add half of each character
            for (int j = 0; j < freq[i] / 2; j++) {
                firstHalf.append((char) ('a' + i));
            }

            // Odd frequency character goes in middle
            if (freq[i] % 2 == 1) {
                middle = (char) ('a' + i);
            }
        }

        StringBuilder result = new StringBuilder();

        result.append(firstHalf);

        if (middle != 0) {
            result.append(middle);
        }

        // Mirror the first half
        result.append(new StringBuilder(firstHalf).reverse());

        return result.toString();
    }
}