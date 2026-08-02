class Solution {
    public String multiply(String num1, String num2) {

        // If either number is 0, answer is 0
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        // Lengths of both strings
        int m = num1.length();
        int n = num2.length();

        // Maximum possible digits = m + n
        int[] result = new int[m + n];

        // Traverse num1 from right to left
        for (int i = m - 1; i >= 0; i--) {

            // Traverse num2 from right to left
            for (int j = n - 1; j >= 0; j--) {

                // Convert character to digit
                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';

                // Multiply the two digits
                int mul = digit1 * digit2;

                /*
                 * p1 -> position for carry
                 * p2 -> position for current digit
                 */
                int p1 = i + j;
                int p2 = i + j + 1;

                // Add multiplication result with existing value
                int sum = mul + result[p2];

                // Store current digit
                result[p2] = sum % 10;

                // Add carry to previous position
                result[p1] += sum / 10;
            }
        }

        // Convert array into string
        StringBuilder ans = new StringBuilder();

        for (int num : result) {

            // Skip leading zeros
            if (!(ans.length() == 0 && num == 0)) {
                ans.append(num);
            }
        }

        return ans.toString();
    }
}