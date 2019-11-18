package coding.test.ctci.tree;

class TreeNode<T> {

    TreeNode<T> parent;

    TreeNode<T> left;

    TreeNode<T> right;

    T data;

    TreeNode(T val) {
        this.data = val;
    }

}
