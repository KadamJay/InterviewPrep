package Essential150.MathGeometry;

/*

Problem    :   https://leetcode.com/problems/happy-number/
Solutions  :   https://youtu.be/ljz85bxOYJ0
Approaches :

| No. | Approach                             | Time Complexity | Space Complexity |
|-----|--------------------------------------|-----------------|------------------|
|  1  | Floyd                                |      O(logn)    |       O(1)       |
|-----|--------------------------------------|-----------------|------------------|
|  2  | Set                                  |      O(logn)    |       O(logn)    |

Time Complexity: Both the isHappySet and isHappyFloyd methods have a time complexity of O(log n),
where n is the input number. This is because the main operation performed is calculating the sum 
of squares of the digits, which takes O(log n) iterations.

Space Complexity: The space complexity is O(log n) as well, considering the worst case scenario.
This is because the set set in isHappySet can contain at most log n elements, and in isHappyFloyd, 
we only use constant space for the variables slow and fast.
*/
import java.util.HashSet;
import java.util.Set;

class HappyNumber {
    public boolean isHappySet(int n) {
        Set<Integer> set = new HashSet<>();

        while (!set.contains(n)) {
            set.add(n);
            n = calculateSumOfSquares(n);
            if (n == 1)
                return true;
        }

        return false;
    }

    public boolean isHappyFloyd(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = calculateSumOfSquares(slow);
            fast = calculateSumOfSquares(calculateSumOfSquares(fast));
            if (fast == 1)
                return true;
        } while (slow != fast);

        return false;
    }

    private int calculateSumOfSquares(int n) {
        int sum = 0;
        while (n != 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();

        // Test Case 1: Happy Number (19)
        int n1 = 19;
        boolean result1 = happyNumber.isHappySet(n1);
        System.out.println("isHappySet(" + n1 + "): " + result1);
        boolean result2 = happyNumber.isHappyFloyd(n1);
        System.out.println("isHappyFloyd(" + n1 + "): " + result2);

        // Test Case 2: Unhappy Number (2)
        int n2 = 2;
        boolean result3 = happyNumber.isHappySet(n2);
        System.out.println("isHappySet(" + n2 + "): " + result3);
        boolean result4 = happyNumber.isHappyFloyd(n2);
        System.out.println("isHappyFloyd(" + n2 + "): " + result4);
    }
}
