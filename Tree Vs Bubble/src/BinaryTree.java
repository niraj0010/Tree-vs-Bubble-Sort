
import java.io.FileWriter;
import java.io.IOException;
    public class BinaryTree {
        public TreeNode root;
        public static int numberOfComparison = 0;
        public void init() {
            root = null;
        }
        public TreeNode getRoot() {
            return root;
        }
        public int numberOfComparison() {
            return numberOfComparison;
        }
        public void setNumberOfComparison(int n) {
            numberOfComparison = n;
        }
        public void Recursive(TreeNode node, FileWriter fileWriter) throws
                IOException {

            TreeNode treenode = node;
            if (treenode.left != null) {
                Recursive(treenode.left, fileWriter);
            }
            fileWriter.write(String.valueOf(treenode.data) + " ");
            if (treenode.right != null) {
                Recursive(treenode.right, fileWriter);
            }
        }
        public void sortedRecursive(TreeNode n) {
            TreeNode treeNode = n;
            if (treeNode.left != null) {
                sortedRecursive(treeNode.left);
            }
            System.out.println(treeNode.data);
            if (treeNode.right != null) {
                sortedRecursive(treeNode.right);
            }
        }
        public void sortedIterative() {
            TreeNode current;
            NodeStack ns = new NodeStack();
            ns.init();
            ns.push(root);
            current = root;
            do {
                while (current != null) {
                    ns.push(current);
                    current = current.left;
                }
                if (ns.isItEmpty() == false) {
                    current = ns.pop();
                    System.out.println(current.data);
                    current = current.right;
                }
            } while (ns.isItEmpty() == false || (current != null));
        }
        public TreeNode makeTreeNode(int n) {
            TreeNode node = new TreeNode();
            node.data = n;
            return node;
        }
        public void setLeft(TreeNode nodeTree, int n) {
            if (nodeTree.left != null) {
                System.out.println("LEFT ERROR");
            } else {
                nodeTree.left = makeTreeNode(n);
            }
        }
        public void setRight(TreeNode nodeTree, int n) {
            if (nodeTree.right != null) {
                System.out.println("RIGHT ERROR");
            } else {
                nodeTree.right = makeTreeNode(n);
            }
        }
        public void makeTree(int n) {
            TreeNode current = root;

            if (root == null) {
                root = makeTreeNode(n);
            } else {
                while (true) {
                    numberOfComparison++;
                    if (n == current.data) {
                        current.repeat++;
                        return;
                    } else if (n < current.data) {
                        numberOfComparison++;
                        if (current.left == null) {
                            setLeft(current, n);
                            return;
                        }
                        current = current.left;
                    } else {
                        numberOfComparison++;
                        if (current.right == null) {
                            setRight(current, n);
                            return;
                        }
                        current = current.right;
                    }
                }
            }
        }
    }
