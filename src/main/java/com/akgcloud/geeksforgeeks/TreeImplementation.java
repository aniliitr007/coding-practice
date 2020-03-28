package com.akgcloud.geeksforgeeks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class TreeImplementation {

    // build tree from inorder and post order array
    public static void buildTree(int[] in, int[] post, TreeNode tree) {

    }
    
    // inorder traversal
    public static void inorderTraversal(TreeNode root){
        
    }

    // level order tree traversal
    public static void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tempNode = null;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while (!q.isEmpty()) {
            tempNode = q.poll();
            System.out.print(tempNode.data + ", ");
            if (tempNode.left != null) {
                q.add(tempNode.left);
            }
            if (tempNode.right != null) {
                q.add(tempNode.right);
            }
        }
    }

    // find last node
    public static TreeNode getLastNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tempNode = null;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while (!q.isEmpty()) {
            tempNode = q.poll();
            if (tempNode.left != null) {
                q.add(tempNode.left);
            }
            if (tempNode.right != null) {
                q.add(tempNode.right);
            }
        }
        return tempNode;
    }

    // find a node
    public static TreeNode findNode(TreeNode root, int n) {
        if (root == null) {
            return null;
        }
        TreeNode tempNode = null;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while (!q.isEmpty()) {
            tempNode = q.poll();
            if (tempNode.data == n) {
                return tempNode;
            }
            if (tempNode.left != null) {
                q.add(tempNode.left);
            }
            if (tempNode.right != null) {
                q.add(tempNode.right);
            }
        }
        return null;
    }

    // delete last node
    public static void deleteLastNode(TreeNode root, int lastNodeData) {
        if (root == null) {
            return;
        }
        TreeNode tempNode = null;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while (!q.isEmpty()) {
            tempNode = q.poll();
            if (tempNode.left != null) {
                if (tempNode.left.data == lastNodeData) {
                    tempNode.left = null;
                    break;
                }
                q.add(tempNode.left);
            }
            if (tempNode.right != null) {
                if (tempNode.right.data == lastNodeData) {
                    tempNode.right = null;
                    break;
                }
                q.add(tempNode.right);
            }
        }
        tempNode = null;
    }

    public static void deleteNode(TreeNode root, int n) {
        if (root == null) {
            return;
        }
        TreeNode deleteNode = findNode(root, n);
        TreeNode lastNode = getLastNode(root);
        if (deleteNode == null || lastNode == null) {
            return;
        }

        int temp = deleteNode.data;
        deleteNode.data = lastNode.data;
        lastNode.data = temp;

        deleteLastNode(root, temp);
    }

    // reverse level order traversal
    public static void reverseLevelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tempNode = null;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        q.add(root);
        while (!q.isEmpty()) {
            tempNode = q.poll();

            if (tempNode.right != null) {
                q.add(tempNode.right);
            }
            if (tempNode.left != null) {
                q.add(tempNode.left);
            }

            s.push(tempNode);
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop().data + ", ");
        }
    }

    // find level of tree using iteration
    public static int findLevel(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 1;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        TreeNode tempNode = null;
        q.add(root);
        // add marker for new level
        q.add(null);
        while (!q.isEmpty()) {
            tempNode = q.poll();
            if (tempNode == null) {
                if (!q.isEmpty()) {
                    q.add(null);
                    level++;
                }
            } else {
                if (tempNode.left != null) {
                    q.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    q.add(tempNode.right);
                }
            }
        }
        return level;
    }

    // level order tree traversal
    public static void levelOrderRecursion(TreeNode root, int level, int l) {
        if (root == null) {
            return;
        }
        if (l == level) {
            System.out.print(root.data + ", ");
        }
        l++;
        if (root.left != null) {
            levelOrderRecursion(root.left, level, l);
        }
        if (root.right != null) {
            levelOrderRecursion(root.right, level, l);
        }
    }

    // find path from root
    public static boolean findPath(TreeNode root, List<Integer> path, int n) {
        if (root == null) {
            return false;
        }
        // add to path
        path.add(root.data);

        if (root.data == n) {
            return true;
        }

        if (root.left != null && findPath(root.left, path, n) || root.right != null && findPath(root.right, path, n)) {
            return true;
        }

        // back tracking : remove from path if not find
        path.remove(path.size() - 1);
        return false;
    }

    public static void findLCA(TreeNode root, int n1, int n2) {
        if (root == null) {
            return;
        }
        List<Integer> path1 = new ArrayList<Integer>();
        List<Integer> path2 = new ArrayList<Integer>();
        if (!findPath(root, path1, n1) || !findPath(root, path2, n2)) {
            return;
        }

        for (int i = 0; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                System.out.print("\nLCA (" + n1 + ", " + n2 + " ) : " + path1.get(i - 1));
                break;
            }
        }
    }

    // This function returns pointer to LCA of two given
    // values n1 and n2. This function assumes that n1 and
    // n2 are present in Binary Tree
    public static TreeNode findLCA2(TreeNode node, int n1, int n2) {
        // Base case
        if (node == null)
            return null;

        // If either n1 or n2 matches with root's key, report
        // the presence by returning root (Note that if a key is
        // ancestor of other, then the ancestor key becomes LCA
        if (node.data == n1 || node.data == n2)
            return node;

        // Look for keys in left and right subtrees
        TreeNode left_lca = findLCA2(node.left, n1, n2);
        TreeNode right_lca = findLCA2(node.right, n1, n2);

        // If both of the above calls return Non-NULL, then one key
        // is present in once subtree and other is present in other,
        // So this node is the LCA
        if (left_lca != null && right_lca != null)
            return node;

        // Otherwise check if left subtree or right subtree is LCA
        return (left_lca != null) ? left_lca : right_lca;
    }

    public static void spiralTreeTraversal() {

    }

    public static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }

        return (t1.data == t2.data) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        a.left = new TreeNode(3);
        a.right = new TreeNode(2);
        a.right.left = new TreeNode(5);
        a.right.right = new TreeNode(4);

        TreeNode b = new TreeNode(1);
        b.left = new TreeNode(2);
        b.right = new TreeNode(3);
        b.left.left = new TreeNode(4);
        b.left.right = new TreeNode(5);

        System.out.println("a and b tree is mirror to each other : " + isMirror(a, b));

        int in[] = { 4, 8, 2, 5, 1, 6, 3, 7 };
        int post[] = { 8, 4, 5, 2, 6, 7, 3, 1 };
        System.out.print("\nlevel order traversal : ");
        levelOrderTraversal(b);
        System.out.print("\nreverse level order traversal : ");
        reverseLevelOrderTraversal(b);
        int level = findLevel(b);
        System.out.println("\nlevel of tree : " + level);
        System.out.print("\nlevel order recusrion : ");
        for (int i = 0; i < level; i++) {
            levelOrderRecursion(b, i, 0);
        }

        // deleteNode(b, 2);
        // System.out.print("\nlevel order traversal after delete : ");
        // levelOrderTraversal(b);

        findLCA(b, 3, 4);
        TreeNode lca = findLCA2(b, 3, 4);
        System.out.print("\nLCA : " + lca.data);
    }

    static class TreeNode {
        public int      data;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int d) {
            data = d;
        }
    }

}
