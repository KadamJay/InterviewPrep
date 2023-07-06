package Essential150.LinkedList;

/*
Problem    :   https://leetcode.com/problems/add-two-numbers/
Solutions  :   https://youtu.be/wgFPrzTjm7s
Approaches :

| No. | Approach                             | Time Complexity      | Space Complexity |
|-----|--------------------------------------|----------------------|------------------|
|  1  | Iterative                            |    O(max(N, M))      |   O(max(N, M))   |




*/
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode resultCurrent = result;
        int sum = 0;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            sum = val1 + val2 + carry;
            carry = sum / 10;
            resultCurrent.next = new ListNode(sum % 10);
            resultCurrent = resultCurrent.next;

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        if (carry == 1) {
            resultCurrent.next = new ListNode(carry);
        }

        return result.next;
    }

    public static void main(String[] args) {
        addTwoNumbersTest();
    }

    public static void addTwoNumbersTest() {
        // Test cases
        ListNode list1 = null;
        ListNode list2 = null;

        ListNode result1 = addTwoNumbers(list1, list2);
        printList(result1); // Expected: null

        list1 = new ListNode(1);
        list2 = null;

        ListNode result2 = addTwoNumbers(list1, list2);
        printList(result2); // Expected: 1

        list1 = null;
        list2 = new ListNode(1);

        ListNode result3 = addTwoNumbers(list1, list2);
        printList(result3); // Expected: 1

        list1 = new ListNode(9);
        list2 = new ListNode(9);

        ListNode result4 = addTwoNumbers(list1, list2);
        printList(result4); // Expected: 8 -> 1

        list1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        list2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode result5 = addTwoNumbers(list1, list2);
        printList(result5); // Expected: 7 -> 0 -> 8
    }

    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
