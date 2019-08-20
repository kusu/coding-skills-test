package coding.test.ctci.linkedlist;

class ListNode {

    ListNode next;
    int data;

    ListNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return printList(this);
    }

    public static int length(ListNode node) {
        int c = 0;

        while (node != null) {
            c++;
            node = node.next;
        }
        return c;
    }

    public static String printList(ListNode node) {

        StringBuilder builder = new StringBuilder();

        while (node != null) {
            builder.append(node.data).append("->");
            node = node.next;
        }

        System.out.println(builder);

        return builder.toString();
    }

    public static ListNode buildList() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);


        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        return n1;
    }

    public static class PartialSum {

        public PartialSum(int carry, ListNode sum){
            this.carry=carry;
            this.sum=sum;
        }

        ListNode sum;
        int carry;
    }
}