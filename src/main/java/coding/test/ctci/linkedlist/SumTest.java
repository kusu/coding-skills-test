package coding.test.ctci.linkedlist;

public class SumTest {


    //1->2->3->4
    //7->8->9

    public static ListNode sumList(ListNode l1, ListNode l2) {
        int len1 = ListNode.length(l1);
        int len2 = ListNode.length(l2);

        ListNode small;
        ListNode large;

        if (len1 < len2) {
            small = l1;
            large = l2;
        } else {
            small = l2;
            large = l1;
        }

        int diff = Math.abs(len1 - len2);

        if (diff > 0) {
            small = padwithZero(small, diff);
        }

        System.out.println("Adding-----");
        ListNode.printList(small);
        ListNode.printList(large);

        ListNode.PartialSum partialSum = sumHelper(small, large, 0);

        if (partialSum.carry > 0) {
            ListNode head = new ListNode(partialSum.carry);
            head.next = partialSum.sum;

            return head;
        } else {
            return partialSum.sum;
        }
    }

    public static ListNode.PartialSum sumHelper(ListNode l1, ListNode l2, int carry) {

        if (l1.next == null && l2.next == null) {
            int sum = l1.data + l2.data + carry;

            ListNode sumNode = new ListNode(sum % 10);
            return new ListNode.PartialSum(sum / 10, sumNode);

        } else {
            ListNode.PartialSum partialSum = sumHelper(l1.next, l2.next, 0);

            int sum = l1.data + l2.data + partialSum.carry;

            ListNode sumNode = new ListNode(sum % 10);

            sumNode.next = partialSum.sum;

            return new ListNode.PartialSum(sum / 10, sumNode);
        }

    }

    public static ListNode padwithZero(ListNode input, int diff) {

        for (int i = 0; i < diff; i++) {
            ListNode zero = new ListNode(0);
            zero.next = input;
            input = zero;
        }

        return input;
    }

    public static ListNode buildList(int num) {
        ListNode head = null;
        while (num > 0) {

            ListNode next = new ListNode(num % 10);

            num = num / 10;

            if (head != null) {
                next.next = head;
            }
            head = next;
        }

        return head;
    }

    public static void main(String[] args) {

        ListNode num1 = buildList(99);

        ListNode num2 = buildList(999);


        ListNode.printList(num1);
        ListNode.printList(num2);

        ListNode sum = sumList(num1, num2);

        ListNode.printList(sum);
    }
}
