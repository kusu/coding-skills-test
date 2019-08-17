package coding.test.ctci.linkedlist;

public class DeleteMiddle {

    public static void deleteMiddle(ListNode mid) {

        mid.data = mid.next.data;
        mid.next = mid.next.next;

    }

    public static void main(String[] args) {
        ListNode n1 = ListNode.buildList();

        ListNode.printList(n1);

        // delete 3
        deleteMiddle(n1.next.next);

        ListNode.printList(n1);

        //delete 2
        deleteMiddle(n1.next);

        ListNode.printList(n1);
    }
}
