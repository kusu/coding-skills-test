package coding.test.ctci.linkedlist;

public class StartOfLoop {

    public ListNode startOfLoop(ListNode head) {

        ListNode fast = head;

        ListNode slow = head;

        while (fast != null && fast.next != null) {

            fast = fast.next.next;

            slow = slow.next;

            if (fast == slow) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        slow = head;

        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args) {

        ListNode n1 = ListNode.buildList();

        ListNode.printList(n1);

    }
}

