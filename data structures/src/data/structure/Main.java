package data.structure;

import java.util.*;

import data.structure.BinaryTreeNode;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        AVL<Integer> tree = new AVL<>();
//        tree.insert(100);
//        tree.insert(108);
//        tree.insert(98);
//        tree.insert(99);
//        tree.insert(80);
//        tree.insert(70);
//
//        System.out.println(tree.toString());

//        BST<Integer> tree = new BST<>();
//        tree.insert(3);
//        tree.insert(2);
//        tree.insert(8);
//        tree.insert(4);
//        tree.insert(6);
//        System.out.println("Print the tree ");
//        tree.inorder();
//        System.out.println("");
//        tree.floorAndCeilOf(5);
        
//        System.out.println("The hight is : " + tree.hight(tree.root));
//        System.out.println("The level of the element is : " + tree.getLevel1(tree.root, 300));
//        tree.printLeaves(tree.root);
//        System.out.println(tree.BF(tree.root));
//        tree.inorder(tree.root);
//        System.out.println();
//        tree.postorder(tree.root);
//        System.out.println();
//        tree.preorder(tree.root);
        Integer[] arr = {1, 6, 8, 5, 4, 2};
        BinaryTree bt = new BinaryTree();
        bt.root = new BinaryTreeNode(1);
        bt.root.leftChild = new BinaryTreeNode(2);
        bt.root.rightChild = new BinaryTreeNode(3);
        bt.root.leftChild.rightChild = new BinaryTreeNode(4);
        bt.root.rightChild.rightChild = new BinaryTreeNode(6);
        bt.root.rightChild.leftChild = new BinaryTreeNode(5);
        bt.root.rightChild.leftChild.rightChild = new BinaryTreeNode(8);
        bt.root.rightChild.leftChild.leftChild = new BinaryTreeNode(7);
 
        bt.rightSideView();
//
//        System.out.println(bt.countSubtrees(root));
//
//        Integer [] array = {100, 99, 78, 88, 26, 85, 55};
//        Heap<Integer> h = new Heap<>(array);
//
//
//        System.out.println(h.isMaxHeap(array));
//        if(h.isMaxHeap(array)){
//            System.out.println("It's max heap");
//        } else {
//            System.out.println("It's min heap");
//        }
//        
        MyLinkedList<Character> d = new MyLinkedList<>();
        d.add('C');
        d.add('B');
        d.add('D');
        d.add('F');
        d.add('A');
        d.print();
        d.change(d.head);
        d.print();
        
        int a[] = {9, 22, 4};
        Stack<Integer> s = new Stack<>();
        
        for (int i = 0; i < 3; i++) {
            if(a[i] > 5)
                s.push(a[i]);
            else
                s.push(s.pop()+5);
        }
        while(!s.isEmpty())
        System.out.println(s.pop());
    }

}
