package Essential150.Arrays;

/*
Problem    :   https://leetcode.com/problems/contains-duplicate/
Solutions  :   https://youtu.be/3OamzN90kPg
Approaches :

| No. | Approach                             | Time Complexity | Space Complexity |
|-----|--------------------------------------|-----------------|------------------|
|  1  | Sorting                              |   O(n log n)    |       O(1)       |
|-----|--------------------------------------|-----------------|------------------|
|  2  | Compare each element with every other|      O(n^2)     |       O(1)       |
|     | element using nested loops           |                 |                  |
|-----|--------------------------------------|-----------------|------------------|
|  3  | Set                                  |       O(n)      |       O(n)       |


 */

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hash = new HashSet<>();
        for (int num : nums) {
            if (hash.contains(num)) {
                return true;
            }
            hash.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicateTest test = new ContainsDuplicateTest();
        test.testContainsDuplicate();
        test.testNoDuplicates();
        test.testEmptyArray();
        test.testSingleElement();
    }
}

class ContainsDuplicateTest {
    public void testContainsDuplicate() {
        int[] nums = { 1, 2, 3, 1 };
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        boolean result = containsDuplicate.containsDuplicate(nums);
        assert result == true : "Failed testContainsDuplicate";
    }

    public void testNoDuplicates() {
        int[] nums = { 1, 2, 3, 4 };
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        boolean result = containsDuplicate.containsDuplicate(nums);
        assert result == false : "Failed testNoDuplicates";
    }

    public void testEmptyArray() {
        int[] nums = {};
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        boolean result = containsDuplicate.containsDuplicate(nums);
        assert result == false : "Failed testEmptyArray";
    }

    public void testSingleElement() {
        int[] nums = { 1 };
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        boolean result = containsDuplicate.containsDuplicate(nums);
        assert result == false : "Failed testSingleElement";
    }
}
