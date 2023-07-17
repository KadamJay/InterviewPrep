package Essential150.Arrays;

/*

Problem    :   https://leetcode.com/problems/encode-and-decode-strings/
Solutions  :   https://youtu.be/B1k_sxOSgv8


==========================================================================================================================
The code implementation is pretty easy once you understand the intuition.

Intuition

We try to encode a List<String> strs into a String.
Let's say we have strs = ["Leet", "Code"].
(1) Then we could simply add # between each word, right? We would have "Leet#Code". 
But it doesn't work because we need to consider the case that # exist in strs.
(2) How if we make a new data structure to hold the length of each String in strs, i.e. List = [4, 4]. 
It doesn't work either because we can not pass the data structure from encode mathod to our decode method.
Therefore, we could add the length of the String and # in front of the String. Then we would have 4#Leet4#Code 
so we know the length of each String, and we also know we need to stop once we meet #.
Note that We must have # because we never know if there's number in front of String, i.e. strs = ["40Leet", "100Code"].

==========================================================================================================================

encode(List<String> strs):

Time Complexity: O(n), where n is the total number of characters in all the strings combined.
Space Complexity: O(n), since the encoded string will have the same length as the combined lengths of all the input strings.

decode(String s):

Time Complexity: O(n), where n is the length of the input string.
Space Complexity: O(n), since the decoded list of strings will require space proportional to the length of the input string.

==========================================================================================================================

Input: "3#abc5#hello"


Iteration 1:

i = 0
idx = 0 (found '#' at index 1)
length = 3 (extracted from substring "3")
i = 1 + 3 + 1 = 5 (move to the next index after the current substring)
Add "abc" to myList
Iteration 2:

i = 5
idx = 5 (found '#' at index 6)
length = 5 (extracted from substring "5")
i = 6 + 5 + 1 = 12 (move to the next index after the current substring)
Add "hello" to myList
Final Output: ["abc", "hello"]

 */
import java.util.ArrayList;
import java.util.List;

public class EncodeDecode {
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String str : strs) {
            encoded.append(str.length()).append("#").append(str);
        }
        return encoded.toString();
    }

    public List<String> decode(String s) {
        List<String> myList = new ArrayList<>();
        int i = 0;

        while (i < s.length()) {
            int idx = i;
            while (s.charAt(idx) != '#') {
                idx++;
            }

            int length = Integer.parseInt(s.substring(i, idx));
            i = idx + 1 + length;
            myList.add(s.substring(idx + 1, i));
        }

        return myList;
    }
}
