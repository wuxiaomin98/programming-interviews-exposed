/*******************************************************************************
 * Tree and graph problems of chapter 5.
 ******************************************************************************/
import java.util.Stack;

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
        Node current = root;
        while (root.right != null) {
            Node current = stack.pop()
            //
        }
    }

    /****************** Test part *********************************************/

    public static Node build() {
        return new Node(5, new Node(2, new Node(1), new Node(3)),
            new Node(6, new Node(4), new Node(7)));
    }

    public static void main(String[] args) {
        Node root = build();
        int height = height(root);
        System.out.println("Height: " + height);
        preorderTraversal_recursion(root);
        preorderTraversal_iteration(root);
        inorderTraversal_recursion(root);

    }
}