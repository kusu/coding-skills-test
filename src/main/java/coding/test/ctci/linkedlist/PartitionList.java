package coding.test.ctci.linkedlist;

public class PartitionList {


    public static ListNode partition(ListNode head, int partition) {

        if (head == null) {
            return head;
        }

        ListNode beforelist = new ListNode(0);

        ListNode beforeListHead = beforelist;
        ListNode afterList = new ListNode(0);

        ListNode afterListHead = afterList;

        while (head != null) {

            if (head.data < partition) {
                beforelist.next = head;
                beforelist = beforelist.next;
            } else {
                afterList.next = head;
                afterList = afterList.next;
            }

            head = head.next;

        }

        afterList.next = null;

        beforelist.next = afterListHead.next;

        return beforeListHead.next;

    }


    public static ListNode buildList() {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(8);
        ListNode n4 = new ListNode(5);
        ListNode n5 = new ListNode(10);
        ListNode n6 = new ListNode(2);
        ListNode n7 = new ListNode(1);


        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        return n1;
    }


    public static void main(String[] args) {

        ListNode n1 = buildList();

        ListNode.printList(n1);
        partition(n1, 5);
        ListNode.printList(n1);

        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);
        n3.next = n4;

        //ListNode.printList(partition(n3, 2));
    }
}
