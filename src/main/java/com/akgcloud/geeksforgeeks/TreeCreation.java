package com.akgcloud.geeksforgeeks;

class TreeNode {
    int      data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        data = val;
    }
}

public class TreeCreation {

    public static TreeNode createTree(int[] parent, int n) {
        TreeNode[] node = new TreeNode[n];
        for (int i = 0; i < n; i++) {
            node[i] = new TreeNode(-1);
        }

        TreeNode root = new TreeNode(-1);

        for (int i = 0; i < n; i++) {
            createNode(parent, i, node, root);
        }
        return root;
    }

    public static void createNode(int[] parent, int i, TreeNode[] created, TreeNode root) {
        if (created[i].data > -1) {
            return;
        }
        created[i].data = i;

        if (parent[i] == -1) {
            root = created[i];
            return;
        }

        if (created[parent[i]].data == -1) {
            createNode(parent, parent[i], created, root);
        }

        TreeNode parentNode = created[parent[i]];

        if (parentNode.left == null) {
            parentNode.left = created[i];
        } else {
            parentNode.right = created[i];
        }
    }

    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    

    public static void main(String[] args) {
        int[] parentIndex = { 1, 5, 5, 2, 2, -1, 3 };
        //TreeNode root = TreeCreation.createTree(parentIndex, parentIndex.length);
        System.out.println("Inorder tree traversal : ");

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        TreeCreation.inorder(root);

    }

}
