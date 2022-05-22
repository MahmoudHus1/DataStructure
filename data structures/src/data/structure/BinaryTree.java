package data.structure;

import java.util.ArrayList;

class BinaryTreeNode {

    public int data;
    public BinaryTreeNode leftChild;
    public BinaryTreeNode rightChild;

    BinaryTreeNode(int data) {
        this.data = data;
        leftChild = null;
        rightChild = null;
    }

}

public class BinaryTree {

    public BinaryTreeNode root;

    public BinaryTree() {
        root = null;
    }

    class maxLevel {

        public int value;
    }

    public void rightSideView(BinaryTreeNode node, int level, maxLevel max, ArrayList list) {
        if (node == null) {
            return;
        }
        if (max.value < level) {
            list.add(node.data);
            max.value = level;
        }
        rightSideView(node.rightChild, 1 + level, max, list);
        rightSideView(node.leftChild, 1 + level, max, list);
    }

    public void rightSideView() {
        rightSideView(this.root);
    }

    public void rightSideView(BinaryTreeNode root) {
        maxLevel max = new maxLevel();
        ArrayList<Integer> list = new ArrayList<>();
        rightSideView(root, 1, max, list);
        System.out.println(list);
    }

}
