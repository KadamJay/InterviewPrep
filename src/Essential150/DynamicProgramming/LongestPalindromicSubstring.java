package Essential150.DynamicProgramming;

/*

Problem    :   https://leetcode.com/problems/longest-palindromic-substring/
Solutions  :   https://www.youtube.com/watch?v=y2BD4MJqV20&ab_channel=NickWhite
           :   https://youtu.be/XYQecbcd6_c
Approaches :


| No. | Approach                             | Time Complexity | Space Complexity |
|-----|--------------------------------------|-----------------|------------------|
|  1  | Expand From Center                   |      O(n^2)     |       O(1)       |
|-----|--------------------------------------|-----------------|------------------|
|  2  | BruteForce                           |      O(n^3)     |       O(1)       |

Brute Force generates all possible substrings using nested for loops (n^2) and for each substring
check if its palindrome (n). Total complexity Time: n^3 and space: 1

*/

class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1)
            return "";

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            int evenLen = expand(s, i, i);
            int oddLen = expand(s, i, i + 1);
            int len = Math.max(oddLen, evenLen);
            if (len > end - start + 1) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    public int expand(String s, int left, int right) {
        if (s == null || left > right)
            return 0;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }

    // Unit tests
    public static void main(String[] args) {
        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();

        // Test case 1: s = "babad", expected output = "bab"
        String s1 = "babad";
        String result1 = solution.longestPalindrome(s1);
        System.out.println(result1.equals("bab") ? "Test case 1 passed" : "Test case 1 failed");

        // Test case 2: s = "cbbd", expected output = "bb"
        String s2 = "cbbd";
        String result2 = solution.longestPalindrome(s2);
        System.out.println(result2.equals("bb") ? "Test case 2 passed" : "Test case 2 failed");

        // Test case 3: s = "a", expected output = "a"
        String s3 = "a";
        String result3 = solution.longestPalindrome(s3);
        System.out.println(result3.equals("a") ? "Test case 3 passed" : "Test case 3 failed");
    }
}
