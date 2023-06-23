package Essential150.Arrays;

/*

Problem    :   https://leetcode.com/problems/valid-anagram/
Solutions  :   https://youtu.be/9UtInBqnCgA
Approaches :

| No. | Approach                             | Time Complexity | Space Complexity |
|-----|--------------------------------------|-----------------|------------------|
|  1  | Sorting                              |   O(n log n)    |       O(1)       |
|-----|--------------------------------------|-----------------|------------------|
|  2  | Count Array                          |      O(n)       |       O(1)       |



The expression s.charAt(i) - 'a' in Java finds the relative position of a character in the alphabet. 
It calculates the difference between the Unicode value of the character at index i in the string s 
and the Unicode value of the lowercase letter 'a'. This represents the character's position in 
the alphabet. For example, if s.charAt(i) is 'd', the result is 3, indicating that 'd' is the fourth 
letter in the alphabet.

*/

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();

        // Valid anagram test cases
        System.out.println(validAnagram.isAnagram("anagram", "nagaram")); // true
        System.out.println(validAnagram.isAnagram("silent", "listen")); // true
        System.out.println(validAnagram.isAnagram("abc", "cba")); // true

        // Invalid anagram test cases
        System.out.println(validAnagram.isAnagram("hello", "world")); // false
        System.out.println(validAnagram.isAnagram("abc", "def")); // false
        System.out.println(validAnagram.isAnagram("foo", "bar")); // false

        // Different length test cases
        System.out.println(validAnagram.isAnagram("abcd", "abc")); // false
        System.out.println(validAnagram.isAnagram("abcd", "abcde")); // false
        System.out.println(validAnagram.isAnagram("a", "")); // false
    }
}
