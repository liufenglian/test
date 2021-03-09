package tree;

import java.util.Arrays;
import java.util.LinkedList;

public class TreeAction {

    public static TreeNode createBinaryTree(LinkedList<Integer> inputList) {
        TreeNode node = null;
        if (inputList == null || inputList.isEmpty()) {
            return null;
        }
        Integer data = inputList.removeFirst();
        System.out.println(data);
        if (data != null) {
            node = new TreeNode(data);
            node.leftTreeNode = createBinaryTree(inputList);
            node.rightTreeNode = createBinaryTree(inputList);
        }
        return node;
    }

    public static void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data);
        preOrder(node.leftTreeNode);
        preOrder(node.rightTreeNode);
    }

    public static void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.leftTreeNode);
        System.out.println(node.data);
        inOrder(node.rightTreeNode);
    }
    public static void posOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.leftTreeNode);
        inOrder(node.rightTreeNode);
        System.out.println(node.data);
    }

    public static void main(String[] args) {
        LinkedList<Integer> inputList = new LinkedList<>(Arrays.asList(new Integer[]{3,2,1,10,9,11,7}));
        TreeNode treeNode = createBinaryTree(inputList);
        System.out.println("前序遍历:");
        preOrder(treeNode);
        System.out.println("中序遍历:");
        inOrder(treeNode);
        System.out.println("后续遍历:");
        posOrder(treeNode);
    }





}
