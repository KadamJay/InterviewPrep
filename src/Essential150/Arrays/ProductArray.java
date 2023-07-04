package Essential150.Arrays;

/*
Problem    :   https://leetcode.com/problems/product-of-array-except-self/
Solutions  :   https://youtu.be/bNvIQI2wAjk
Approaches :

| No. | Approach                             | Time Complexity      | Space Complexity |
|-----|--------------------------------------|----------------------|------------------|
|  1  | In place                             |          O(n)        |       O(1)       |
|-----|--------------------------------------|----------------------|------------------|
|  2  | With Aux pre and post array          |          O(n)        |       O(n)       |

where n is the length of the input array strs, and k is the maximum length of the strings in strs.
*/
import java.util.Arrays;

public class ProductArray {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];

        // Calculate prefix products
        int prefixProduct = 1;
        for (int i = 0; i < len; i++) {
            result[i] = prefixProduct;
            prefixProduct *= nums[i];
        }

        // Calculate postfix products and multiply with prefix products
        int postfixProduct = 1;
        for (int i = len - 1; i >= 0; i--) {
            result[i] *= postfixProduct;
            postfixProduct *= nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        // Test Case
        ProductArray productArray = new ProductArray();
        int[] nums = { 1, 2, 3, 4 };
        int[] result = productArray.productExceptSelf(nums);
        System.out.println("Product Array: " + Arrays.toString(result));
    }
}
