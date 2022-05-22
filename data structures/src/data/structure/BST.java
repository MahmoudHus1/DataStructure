package data.structure;

import java.util.ArrayList;
import java.util.List;

public class BST<T extends Comparable<T>> implements Tree<T> {

    protected TreeNode<T> root;
    protected int size = 0;

    class TreeNode<T> {

        protected T data;
        protected TreeNode<T> left;
        protected TreeNode<T> right;

        public TreeNode(T key) {
            data = key;
            left = right = null;
        }
    }

    public BST() {
    }

    public BST(T t) {
        insert(t);
    }

    public BST(T[] arr) {
        for (T x : arr) {
            insert(x);
        }
    }

    public int hight(TreeNode<T> root) {
        if (root == null) {
            return -1;
        } else {
            return 1 + (Math.max(hight(root.left), hight(root.right)));
        }
    }

    @Override
    public boolean search(T element) {
        TreeNode<T> current = root;

        while (current != null) {
            if (element.compareTo(current.data) > 0) {
                current = current.right;
            } else if (element.compareTo(current.data) < 0) {
                current = current.left;
            } else {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean insert(T element) {
        if (root == null) {
            root = new TreeNode<>(element);
            size++;
            return true;
        }
        TreeNode<T> parent = root, current = root;
        while (current != null) {
            if (element.compareTo(current.data) > 0) {
                parent = current;
                current = current.right;
            } else if (element.compareTo(current.data) < 0) {
                parent = current;
                current = current.left;
            } else {
                return false;
            }
        }
        if (element.compareTo(parent.data) > 0) {
            parent.right = new TreeNode<>(element);
        } else if (element.compareTo(parent.data) < 0) {
            parent.left = new TreeNode<>(element);
        }
        size++;
        return true;
    }

    @Override
    public void inorder() {
        inorder(root);
    }

    // left--root--right
    public void inorder(TreeNode<T> root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    @Override
    public void postorder() {
        postorder(root);
    }

    // left--right--root
    public void postorder(TreeNode<T> root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        inorder(root.right);
        System.out.print(root.data + " ");
    }

    @Override
    public void preorder() {
        preorder(root);
    }

    // root--left--right
    public void preorder(TreeNode<T> root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        inorder(root.left);
        inorder(root.right);
    }

    @Override
    public int size() {
        return size;
    }

    public int getSize() {
        return getSize(root);
    }

    private int getSize(TreeNode<T> root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + getSize(root.left) + getSize(root.right);
        }
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public boolean delete(T e) {
        root = delete(root, e);
        return true;
    }

    public TreeNode<T> maximumKey(TreeNode<T> root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    public TreeNode<T> delete(TreeNode<T> root, T element) {
        if (root == null) {
            return null;
        } else if (element.compareTo(root.data) > 0) {
            root.right = delete(root.right, element);
        } else if (element.compareTo(root.data) < 0) {
            root.left = delete(root.left, element);
        } else {
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left != null && root.right != null) {
                TreeNode predecessor = maximumKey(root.left);
                root.data = (T) predecessor.data;

                root.left = delete(root.left, (T) predecessor.data);
            } else {
                TreeNode child = (root.left != null) ? root.left : root.right;
                root = child;
            }
        }

        return root;
    }

    public int getLevel1(TreeNode<T> root, T element) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        if (root.data.compareTo(element) == 0) {
            return 0;
        }
        if (element.compareTo(root.data) < 0) {
            return getLevel1(root.left, element) + 1;
        } else {
            return getLevel1(root.right, element) + 1;
        }
    }

    public int getLevel(TreeNode<T> root, T element) {
        return getLevel(root, element, 0);
    }

    public int getLevel(TreeNode<T> root, T element, int level) {
        if (search(element)) {
            if (root == null) {
                return -1;
            }
            TreeNode<T> current = root;

            while (current != null) {
                if (element.compareTo(current.data) > 0) {
                    level++;
                    current = current.right;
                } else if (element.compareTo(current.data) < 0) {
                    level++;
                    current = current.left;
                } else {
                    return level;
                }
            }
        }
        return -1;
    }

    public T Max() {
        return Max(root);
    }

    private T Max(TreeNode<T> root) {
        if (root == null) {
            return null;
        } else if (size() == 1) {
            return root.data;
        }
        TreeNode<T> current = root;
        TreeNode<T> max = null;
        while (current != null) {
            max = current;
            current = current.right;
        }
        return max.data;
    }

    public T Min() {
        return Min(root);
    }

    private T Min(TreeNode<T> root) {
        if (root == null) {
            return null;
        } else if (size() == 1) {
            return root.data;
        }
        TreeNode<T> current = root;
        TreeNode<T> min = null;
        while (current != null) {
            min = current;
            current = current.left;
        }
        return min.data;
    }

    public void DoubleTree() {
        DoubleTree(root);
    }

    private void DoubleTree(TreeNode<T> root) {
        if (root == null) {
            return;
        }
        DoubleTree(root.left);
        DoubleTree(root.right);
        TreeNode<T> old = root.left;
        root.left = new TreeNode<T>(root.data);
        root.left.left = old;
    }

    public void printAllRootToLeafPaths() {
        printAllRootToLeafPaths(root, new ArrayList<T>());
    }

    private void printAllRootToLeafPaths(TreeNode<T> node, ArrayList<T> path) {
        if (node == null) {
            return;
        }

        path.add(node.data);

        if (node.left == null && node.right == null) {
            System.out.println(path);

        } else {
            printAllRootToLeafPaths(node.left, new ArrayList<T>(path));
            printAllRootToLeafPaths(node.right, new ArrayList<T>(path));
        }
    }

    public void printLeaves(TreeNode<T> root) {
        ArrayList<T> leaves = new ArrayList<>();
        printLeaves(root, leaves);
        System.out.println("Print the leaves.... ");
        System.out.println(leaves);
    }

    public void printLeaves(TreeNode<T> root, ArrayList<T> Leaves) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            Leaves.add(root.data);
        } else {
            printLeaves(root.left, Leaves);
            printLeaves(root.right, Leaves);
        }
    }

    public boolean findPair(TreeNode root, int sum, ArrayList<Integer> list) {
        if (root == null) {
            return false;
        }
        if (findPair(root.left, sum, list)) {
            return true;
        }
        if (list.contains(sum - (Integer) root.data)) {
            System.out.println("Pair found (" + (sum - (Integer) root.data) + ", "
                    + root.data + ")");
            return true;
        } else {
            list.add((Integer) root.data);
        }

        return findPair(root.right, sum, list);
    }

    public void what(T e) {
        what(root, e, "root");
    }

    private void what(TreeNode root, T e, String what) {
        if (root == null) {
            System.out.println("not exist ");
        }
        int com = ((Comparable) root.data).compareTo(e);
        if (com > 0) {
            what(root.left, e, "left");
        } else if (com < 0) {
            what(root.right, e, "right");
        } else {
            System.out.println(what);
        }
    }

    public int maxLeafNodesSum() {
        return maxLeafNodesSum(this.root);
    }

    private int maxLeafNodesSum(TreeNode rootNode) {
        if (rootNode == null) {
            return 0;
        }
        int res = 0;
        MyQueueLinked<TreeNode> queue = new MyQueueLinked<>();
        queue.enqueue(rootNode);
        while (!queue.isEmpty()) {
            int counter = queue.size;
            int sum = 0;
            while (true) {
                if (counter-- <= 0) {
                    break;
                }
                TreeNode tmp = queue.peek();
                queue.dequeue();
                if (tmp.left == null && tmp.right == null) {
                    sum = sum + (int) tmp.data;
                }
                if (tmp.left != null) {
                    queue.enqueue(tmp.left);
                }
                if (tmp.right != null) {
                    queue.enqueue(tmp.right);
                }
            }
            res = Math.max(sum, res);
        }
        return res;
    }

    public void deleteTree(TreeNode root) {
        if (root == null) {
            return;
        }
        deleteTree(root.left);
        deleteTree(root.right);
        delete((T) root.data);
    }

    public void floorAndCeilOf(T key) {
        TreeNode<T>[] arrNode = new TreeNode[2];

        arrNode[0] = new TreeNode(-1);
        arrNode[1] = new TreeNode(-1);
        floorOf(arrNode, key, root);
        ceilOf(arrNode, key, root);
        System.out.println("The floor of number " + key + " is : " + arrNode[0].data + "  and the ceil of this number is : " + arrNode[1].data);
    }

    public void floorOf(TreeNode<T>[] arrNode, T key, TreeNode<T> root) {
        if (root != null) {
            if ((key.compareTo(root.data) >= 0) && (root.data.compareTo(arrNode[0].data) > 0)) {
                arrNode[0] = root;
                floorOf(arrNode, key, root.right);
            } else {
                floorOf(arrNode, key, root.left);
                floorOf(arrNode, key, root.right);
            }
        }
    }

    public void ceilOf(TreeNode<T>[] arrNode, T key, TreeNode<T> root) {
        if (root != null) {
            if ((root.data.compareTo(key) >= 0) && (root.data.compareTo(arrNode[1].data) < 0)) {
                arrNode[1] = root;
                ceilOf(arrNode, key, root.left);
            } else {
                ceilOf(arrNode, key, root.left);
                ceilOf(arrNode, key, root.right);
            }
        }
    }

    public void pushTreeNodes(TreeNode root, List<TreeNode> nodes) {
        if (root == null) {
            return;
        }
        pushTreeNodes(root.left, nodes);
        nodes.add(root);
        pushTreeNodes(root.right, nodes);
    }

    public TreeNode buildBalancedBST(List<TreeNode> nodes, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = nodes.get(mid);
        root.left = buildBalancedBST(nodes, start, mid - 1);
        root.right = buildBalancedBST(nodes, mid + 1, end);
        return root;
    }

    public TreeNode constructBalancedBST(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        pushTreeNodes(root, nodes);
        return buildBalancedBST(nodes, 0, nodes.size() - 1);
    }

    public void BalancedBST() {
        this.root = constructBalancedBST(root);
    }

    public void print() {
        System.out.println(traversePreOrder(root));
    }

    public void traverseNodes(StringBuilder sb, String padding, String pointer, TreeNode node, boolean hasRightSibling) {
        if (node != null) {
            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.data);

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append("│  ");
            } else {
                paddingBuilder.append("   ");
            }

            String paddingForBoth = paddingBuilder.toString();
            String pointerRight = "└──";
            String pointerLeft = (node.right != null) ? "├──" : "└──";

            traverseNodes(sb, paddingForBoth, pointerLeft, node.left, node.right != null);
            traverseNodes(sb, paddingForBoth, pointerRight, node.right, false);
        }
    }

    public String traversePreOrder(TreeNode root) {

        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(root.data);

        String pointerRight = "└──";
        String pointerLeft = (root.right != null) ? "├──" : "└──";

        traverseNodes(sb, "", pointerLeft, root.left, root.right != null);
        traverseNodes(sb, "", pointerRight, root.right, false);

        return sb.toString();
    }

}
