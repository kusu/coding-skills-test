package coding.test.ctci.tree;

public class FirstCommonAncestor {


    public static TreeNode<Integer> commonAncestor(TreeNode<Integer> t1, TreeNode<Integer> t2) {

    }

    public static void main(String[] args) {

        // robert guster, 972-499-7858

        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        TreeNode<Integer> root = MinHeightTree.buildTree(array, 0, array.length);

        int[] array2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        TreeNode<Integer> root2 = MinHeightTree.buildTree(array2, 0, array2.length);

        BTreePrinter.printNode(root);

        BTreePrinter.printNode(root2);

    }
}
