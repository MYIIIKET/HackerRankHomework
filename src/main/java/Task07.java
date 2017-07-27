public class Task07 {
    private class Node {
        int data;
        Node left;
        Node right;
    }

    boolean checkBST(Node root) {
        if (root != null)
            return check(root);
        else return true;
    }

    private static boolean check(Node node) {
        boolean isBST = true;
        if (node != null) {
            if (node.left != null) {
                isBST &= (getMax(node.left) < node.data) ? check(node.left) : false;
            }
            if (node.right != null) {
                isBST &= (getMin(node.right) > node.data) ? check(node.right) : false;
            }
        }
        return isBST;
    }

    private static int getMin(Node node) {
        return (node.left != null) ? getMin(node.left) : node.data;
    }

    private static int getMax(Node node) {
        return (node.right != null) ? getMax(node.right) : node.data;
    }
}
