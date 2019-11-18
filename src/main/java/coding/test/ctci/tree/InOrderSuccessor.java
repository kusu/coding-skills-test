package coding.test.ctci.tree;

public class InOrderSuccessor {


    public static TreeNode<Integer> inorderSuccessor(TreeNode<Integer> node) {

        if (node == null || node.parent == null) {
            return node;
        }

        if (node.right != null) {
            TreeNode<Integer> start = node.right;

            while (start.left != null) {
                start = start.left;
            }

            return start;
        } else {
            TreeNode<Integer> start = node.parent;
            while (start.left != node) {
                node = start;
                start = start.parent;
            }

            return start;
        }

    }


    public static void main(String[] args) {

        // robert guster, 972-499-7858

        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        TreeNode<Integer> root = MinHeightTree.buildTree(array, 0, array.length);

        int[] array2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        TreeNode<Integer> root2 = MinHeightTree.buildTree(array2, 0, array2.length);

        BTreePrinter.printNode(root);

        BTreePrinter.printNode(root2);


        TreeNode<Integer> nine = inorderSuccessor(root2.right.left.right);

        TreeNode<Integer> four = inorderSuccessor(root2.left);

        System.out.println(nine.data);
        System.out.println(four.data);

        TreeNode<Integer> six = inorderSuccessor(root2.left.right.right);
        System.out.println(six.data);

    }
}
