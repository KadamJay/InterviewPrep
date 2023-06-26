package Essential150.TwoPointers;

/*

Problem    :   https://leetcode.com/problems/valid-palindrome/description/
Solutions  :   https://youtu.be/jJXJ16kPFWg
Approaches :

| No. | Approach                             | Time Complexity | Space Complexity |
|-----|--------------------------------------|-----------------|------------------|
|  1  | Two Pointers                         |       O(n )     |       O(1)       |

*/

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (!isAlphanum(s.charAt(left))) {
                left++;
            } else if (!isAlphanum(s.charAt(right))) {
                right--;
            } else {
                if (!isEqualIgnoreCase(s.charAt(left), s.charAt(right))) {
                    return false;
                }
                left++;
                right--;
            }
        }
        return true;
    }

    public static boolean isEqualIgnoreCase(char c1, char c2) {
        if (isLetter(c1) && isLetter(c2)) {
            return toLowerCase(c1) == toLowerCase(c2);

        }
        return c1 == c2;
    }

    public static char toLowerCase(char c) {
        if ('A' <= c && c <= 'Z')
            return (char) (c + 32);
        return c;
    }

    public static boolean isAlphanum(char c) {
        return isLetter(c) || isDigit(c);
    }

    public static boolean isLetter(char c) {
        return ('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z');
    }

    public static boolean isDigit(char c) {
        return ('0' <= c && c <= '9');
    }

    public static void main(String[] args) {
        // Test Cases
        System.out.println(isPalindrome("")); // true
        System.out.println(isPalindrome("a")); // true
        System.out.println(isPalindrome("ab")); // false
        System.out.println(isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(isPalindrome("race a car")); // false
    }

}
