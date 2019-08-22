package coding.test.ctci.tree;

import coding.test.ctci.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LinkedTree {

    private static List<ListNode> buildLinkedList(TreeNode<Integer> treeNode) {

        Map<Integer, ListNode> bfsMap = new LinkedHashMap<>();


        visit(bfsMap, treeNode, 0);

        for (Map.Entry<Integer, ListNode> entry : bfsMap.entrySet()) {
            System.out.print("Depth" + entry.getKey()+":>");
            ListNode.printList(entry.getValue());
        }

        return new ArrayList<>(bfsMap.values());
    }

    private static void visit(Map<Integer, ListNode> nodeMap, TreeNode<Integer> root, int depth) {
        if (root == null) {
            return;
        }

        if (!nodeMap.containsKey(depth)) {
            nodeMap.put(depth, new ListNode(root.data));
        } else {
            ListNode exist = nodeMap.get(depth);

            while (exist.getNext() != null) {
                exist = exist.getNext();
            }

            ListNode next = new ListNode(root.data);
            exist.setNext(next);
        }

        if (root.left != null) {
            visit(nodeMap, root.left, depth + 1);
        }
        if (root.right != null) {
            visit(nodeMap, root.right, depth + 1);
        }
    }

    public static void main(String[] args) {

        // robert guster, 972-499-7858

        int[] array2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        TreeNode<Integer> root2 = MinHeightTree.buildTree(array2, 0, array2.length);

        BTreePrinter.printNode(root2);

        buildLinkedList(root2);
    }
}
