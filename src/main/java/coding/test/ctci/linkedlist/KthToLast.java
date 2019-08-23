package coding.test.ctci.linkedlist;

public class KthToLast {

    public static ListNode kthToLast(ListNode head, int k) {

        ListNode slow = head;
        ListNode fast = head;
        int count = 0;

        while (fast.next != null) {

            fast = fast.next;
            count++;

            if (count >= k) {
                slow = slow.next;
            }

        }

        return slow;

    }

    public static void main(String[] args) {
        ListNode n1 = ListNode.buildList();

        ListNode.printList(n1);


        ListNode kth = kthToLast(n1, 4);

        if (kth != null) {
            System.out.println(kth.data);
        } else {
            System.out.println("null");
        }
    }

}
