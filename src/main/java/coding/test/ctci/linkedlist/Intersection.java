package coding.test.ctci.linkedlist;

public class Intersection {


    public static ListNode interSection(ListNode list1, ListNode list2) {

        if (list1 == null || list2 == null) {
            return null;
        }

        int len1 = ListNode.length(list1);
        int len2 = ListNode.length(list2);

        int diff = Math.abs(len1 - len2);


        ListNode larger;
        ListNode smaller;

        if (len1 >= len2) {
            larger = list1;
            smaller = list2;
        } else {
            larger = list2;
            smaller = list1;
        }

        for (int i = 0; i < diff; i++) {
            larger = larger.next;
        }

        while (larger != null) {

            if (larger == smaller) {
                return larger;
            }

            larger = larger.next;
            smaller = smaller.next;
        }

        return null;
    }

    public static void main(String[] args) {

        ListNode n1 = ListNode.buildList();

        ListNode n2 = ListNode.buildList();

        n1.next.next = n2;

        ListNode.printList(n1);
        ListNode.printList(n2);

        ListNode.printList(interSection(n1,n2));
    }
}
