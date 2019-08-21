package coding.test.ctci.tree;

public class MinHeightTree {


    public static TreeNode<Integer> buildTree(int[] array, int start, int end) {

        if (start > end || start >= array.length) {
            return null;
        }

        if (start == end) {
            return new TreeNode<>(array[start]);
        }

        int mid = (start + end) / 2;

        TreeNode<Integer> root = new TreeNode<>(array[mid]);

        root.left = buildTree(array, start, mid - 1);

        root.right = buildTree(array, mid + 1, end);

        return root;

    }

    public static void main(String[] args) {

        // robert guster, 972-499-7858

        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        TreeNode<Integer> root = buildTree(array, 0, array.length);

        int[] array2 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        TreeNode<Integer> root2 = buildTree(array2, 0, array2.length);

        BTreePrinter.printNode(root);

        BTreePrinter.printNode(root2);
    }
}
