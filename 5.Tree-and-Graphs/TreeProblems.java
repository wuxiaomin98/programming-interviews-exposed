/*******************************************************************************
 * Tree and graph problems of chapter 5.
 ******************************************************************************/
import java.util.Stack;
import static java.lang.System.out;

import java.util.*;
class Node {
    Node left;
    Node right;
    int value;

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public Node(int value) {
        this(value, null, null);
    }

    public void printValue() {
        System.out.print(value + " ");
    }
}

public class TreeProblems {

    /**
     * Height of the tree.
     */
    public static int height(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    /**
     * Preorder traversal, print out the value.
     */
    public static void preorderTraversal_recursion(Node root) {
        if (root == null) return;
        root.printValue();
        preorderTraversal_recursion(root.left);
        preorderTraversal_recursion(root.right);
    }

    public static void preorderTraversal_iteration(Node root) {
        Stack<Node> stack = new Stack<Node>();
        stack.push(root);
        while (!stack.empty()) {
            Node current = stack.pop();
            current.printValue();
            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);
        }
    }

    /**
     * Inorder traversal.
     */
    public static void inorderTraversal_recursion(Node root) {
        if (root == null) return;
        inorderTraversal_recursion(root.left);
        root.printValue();
        inorderTraversal_recursion(root.right);
    }

    public static void inorderTraversal_iteration(Node root) {
        Stack<Node> stack = new Stack<Node>();
        while (!stack.empty() || root != null) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                root.printValue();
                root = root.right;
            }
        }
    }


    /**
     * Lowest common ancestor.
     */
    public static Node findLowestCommonAncestor(Node root, int value1, int value2) {
        while (root != null) {
            if (value1 <= root.value && value2 >= root.value) {
                return root;
            } else if (value1 < root.value && value2 < root.value) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return null;
    }

    /**
     * Binary tree to heap.
     * Given a set of integers in an unordered binary tree. Use an array sorting
     * routine to transform the tree into a heap that uses a balanced binary tree.
     */
/*    public static Node heapifyBinaryTree(Node root) {
        int size = traverse(root, 0, null);
        Node[] array = new Node[size];
        traverse(root, 0, array);

        // sort array
        Arrays.sort(array, new Comparator<Node>() {
            @Override
            public int compare(Node m, Node n) {
                int mv = m.value;
                int nv = n.value;
                return mv < nv ? -1 : (mv == nv ? 0 : 1);  //?
            }
        });

        // reassign
        for (int i = 0; i < size; i++) {
            int left = 2 * i - 1;
            int right = 2 * i + 1;
            if (left < size) {
                array[i].left = array[left];  //?
            }
            if (right < size) {
                array[i].right = array[right];
            }
        }
        return array[0];
    }

    private static int traverse(Node root, int count, Node[] array) {
        if (root == null) return count;
        if (array != null) {
            array[count] = root;
        }
        count++;
        count = traverse(root.left, count, array);
        count = traverse(root.right, count, array);
        return count;
    }

    private static int inorderCount(Node root, int count) {
        if (root == null) return count;
        count++;
        inorderCount(root.left, count);
        inorderCount(root.right, count);
        return count;
    }

    private static Node[] inorderTraverse(Node root, Node[] array, int count) {
        if (root == null) return array;
        inorderTraverse(root.left, array, count);
        array[count] = root;
        array = inorderTraverse(root.left, array, count);
        array = inorderTraverse(root.right, array, count);
        return array;
    }
*/
    /****************** Test part *********************************************/
    /*     4
     *  2     6
     * 1 3   5 7
     */
    public static Node build() {
        return new Node(4, new Node(2, new Node(1), new Node(3)),
            new Node(6, new Node(5), new Node(7)));
    }

    public static void main(String[] args) {
        Node root = build();
        int height = height(root);
        out.println("Height: " + height);

        out.println("Preorder: ");
        preorderTraversal_recursion(root);
        preorderTraversal_iteration(root);

        out.println("\nInorder: ");
        inorderTraversal_recursion(root);
        out.println();
        inorderTraversal_iteration(root);

        out.println("\nfindLowestCommonAncestor: 1, 3");
        findLowestCommonAncestor(root, 1, 9).printValue(); //?

        //out.println("\nheapifyBinaryTree:");
        //heapifyBinaryTree(root).printValue();
    }
}