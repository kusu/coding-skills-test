package coding.test.ctci.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicate {

    public static void deleteDuplicateNode(ListNode head) {

        Set<Integer> data = new HashSet<Integer>();
        data.add(head.data);

        ListNode prev = head;
        ListNode current = head.next;

        while (current != null) {
            if (data.contains(current.data)) {
                prev.next = prev.next.next;
            } else {
                data.add(current.data);
                prev = prev.next;
            }

            current = current.next;
        }
    }


    public static void main(String[] args) {

        ListNode n1 = ListNode.buildList();

        ListNode.printList(n1);
        deleteDuplicateNode(n1);
        ListNode.printList(n1);
    }

}
