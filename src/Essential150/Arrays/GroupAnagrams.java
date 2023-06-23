package Essential150.Arrays;

/*
Problem    :   https://leetcode.com/problems/group-anagrams/
Solutions  :   https://youtu.be/vzdNOK2oB2E
Approaches :

| No. | Approach                             | Time Complexity      | Space Complexity |
|-----|--------------------------------------|----------------------|------------------|
|  1  | Sorting + Map                        |   O(n * k * log(k))  |   O(n * k)       |
|-----|--------------------------------------|----------------------|------------------|
|  2  | countArray + Map                     |   O(n * k)           |   O(n * k)       |

where n is the length of the input array strs, and k is the maximum length of the strings in strs.
*/
import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagramsWithSorting(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] keyChar = s.toCharArray();
            Arrays.sort(keyChar);
            String keyStr = String.valueOf(keyChar);

            if (!map.containsKey(keyStr))
                map.put(keyStr, new ArrayList<>());

            map.get(keyStr).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagramsWithCountArray(String[] strs) {

        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] count = new char[26];

            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            String keyStr = String.valueOf(count);

            if (!map.containsKey(keyStr))
                map.put(keyStr, new ArrayList<>());

            map.get(keyStr).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams groupAnagrams = new GroupAnagrams();

        // Test cases
        String[] strs1 = { "eat", "tea", "tan", "ate", "nat", "bat" };
        List<List<String>> result1 = groupAnagrams.groupAnagramsWithSorting(strs1);
        System.out.println("with groupAnagramsWithSorting");
        System.out.println(result1);
        result1 = groupAnagrams.groupAnagramsWithCountArray(strs1);
        System.out.println("with groupAnagramsWithCountArray");
        System.out.println(result1);
        // Expected output: [["ate","eat","tea"],["nat","tan"],["bat"]]

        String[] strs2 = { "abc", "cba", "xyz", "zyx" };
        List<List<String>> result2 = groupAnagrams.groupAnagramsWithSorting(strs2);
        System.out.println(result2);
        result2 = groupAnagrams.groupAnagramsWithCountArray(strs2);
        System.out.println("with groupAnagramsWithCountArray");
        System.out.println(result2);
        // Expected output: [["abc","cba"],["xyz","zyx"]]

        String[] strs3 = { "a" };
        List<List<String>> result3 = groupAnagrams.groupAnagramsWithSorting(strs3);
        System.out.println(result3);
        result3 = groupAnagrams.groupAnagramsWithCountArray(strs3);
        System.out.println("with groupAnagramsWithCountArray");
        System.out.println(result3);
        // Expected output: [["a"]]

        String[] strs4 = { "ab", "ba", "cd", "ef" };
        List<List<String>> result4 = groupAnagrams.groupAnagramsWithSorting(strs4);
        System.out.println(result4);
        result4 = groupAnagrams.groupAnagramsWithCountArray(strs4);
        System.out.println("with groupAnagramsWithCountArray");
        System.out.println(result4);
        // Expected output: [["ab","ba"],["cd"],["ef"]]

        String[] strs5 = {};
        List<List<String>> result5 = groupAnagrams.groupAnagramsWithSorting(strs5);
        System.out.println(result5);
        result5 = groupAnagrams.groupAnagramsWithCountArray(strs5);
        System.out.println("with groupAnagramsWithCountArray");
        System.out.println(result5);
        // Expected output: []

    }
}
