package coding.test.ctci.linkedlist;

import java.util.Stack;

public class PalindromeList {

    public static boolean isPalindrome(ListNode node) {
        Stack<Integer> stack = new Stack<Integer>();

        ListNode fast = node;
        ListNode slow = node;

        if (node.next == null) {
            return true;
        }

        while (fast != null && fast.next != null) {
            stack.push(slow.data);

            fast = fast.next.next;

            slow = slow.next;

        }

        if (fast != null) {
            stack.push(slow.data);
            slow = slow.next;
        }

        while (slow != null) {

            int data = stack.pop();

            if (slow.data != data) {
                return false;
            }

            slow = slow.next;

        }

        return true;
    }

    public static ListNode buildPalindrome() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(2);
        ListNode n6 = new ListNode(1);


        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        return n1;
    }

    public static void main(String[] args) {

        ListNode n1 = ListNode.buildList();

        ListNode.printList(n1);
        System.out.println(isPalindrome(n1));

        System.out.println(isPalindrome(buildPalindrome()));
    }
}
