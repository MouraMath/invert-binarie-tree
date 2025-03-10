package org.example;

public class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);

        return root;
    }


    private static void printTree(TreeNode root, String prefix, boolean isLeft) {
        if (root == null) {
            return;
        }

        System.out.println(prefix + (isLeft ? "├── " : "└── ") + root.val);

        printTree(root.left, prefix + (isLeft ? "│   " : "    "), true);
        printTree(root.right, prefix + (isLeft ? "│   " : "    "), false);
    }


    private static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("Empty tree");
            return;
        }

        System.out.println(root.val);
        printTree(root.left, "", true);
        printTree(root.right, "", false);
    }

    public static void main(String[] args) {
        // Create a sample tree
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        // Print the original tree structure
        System.out.println("Original tree structure");
        printTree(root);

        // Invert the tree
        TreeNode inverted = new TreeNode(0).invertTree(root);

        // Print the inverted tree structure
        System.out.println("\nInverted tree structure");
        printTree(inverted);
    }
}
