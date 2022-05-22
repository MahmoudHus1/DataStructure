package data.structure;

public class MyLinkedList<T> extends MyAbstractList<T> implements MyList<T> {

    class Node<T> {

        T element;
        Node<T> next;
        Node<T> node;

        public Node(Node node) {
            this.node = node;
        }

        public Node() {
        }

        public Node(T e) {
            this.element = e;
        }
    }

    public Node<T> head, tail;

    public MyLinkedList() {

    }

    public MyLinkedList(T[] data) {
        super(data);
    }

    public void addFirst(T e) {
        Node<T> newNode = new Node<>(e);
        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addLast(T e) {
        if (tail == null) {
            addFirst(e);
        } else {
            Node<T> newNode = new Node<>(e);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public T removeFirst() {
        if (head != null) {
            T old = head.element;
            size--;
            if (head.next == null) {
                head = tail = null;
                return old;
            }
            head = head.next;
            return old;
        }
        return null;
    }

    public T removeLast() {
        if (tail == null) {
            return null;
        } else if (head == tail) {
            T old = head.element;
            removeFirst();
            return old;

        } else {
            Node<T> current = head;
            for (int i = 0; i < size - 2; i++) {
                current = current.next;
            }
            T temp = tail.element;
            current.next = null;
            tail = current;
            size--;
            return temp;
        }
    }

    public T getFirst() {
        return head.element;
    }

    public T getLast() {
        return tail.element;
    }

    @Override
    public void add(T e) {
        addFirst(e);
    }

    @Override
    public void add(int index, T e) {
        if (index < 0) {
            return;
        } else if (index >= size) {
            addLast(e);
        } else if (index == 0) {
            addFirst(e);
        } else {
            Node<T> temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            Node<T> newNode = new Node(e);
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }

    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int indexOf(T e) {
        if (head == null) {
            return -1;
        }
        if (head == tail) {
            if (head.element.equals(e)) {
                return 0;
            } else {
                return -1;
            }
        }

        Node<T> temp = head;
        for (int i = 0; i < size - 1; i++) {
            if (e.equals(temp.element)) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    @Override
    public boolean contains(T e) {
        return indexOf(e) != -1;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node<T> temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        return temp.element;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int lastIndexOf(T e) {
        if (head == null) {
            return -1;
        }
        if (head == tail) {
            if (head.element.equals(e)) {
                return 0;
            }
        }
        int index = -1;
        Node<T> temp = head;
        for (int i = 0; i < size - 1; i++) {
            if (temp.element.equals(e)) {
                index = i;
            }
            temp = temp.next;
        }
        return index;
    }

    @Override
    public T remove(T e) {
        if (head == tail) {
            if (head.element.equals(e)) {
                return removeFirst();
            }
        }
        if (head.element.equals(e)) {
            return removeFirst();
        }
        if (tail.element.equals(e)) {
            return removeLast();
        }
        if (head == null) {
            return null;
        }
        Node<T> prev = head, current;
        for (int i = 0; i < size - 1; i++) {
            current = prev.next;
            if (current.element.equals(e)) {
                T temp = current.element;
                prev.next = current.next;
                current = null;
                return temp;
            }
            prev = prev.next;
        }
        return null;
    }

    @Override
    public T removeByIndex(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        if (head == null) {
            return null;
        }
        if (index == 0) {
            return removeFirst();
        }
        if (index == size - 1) {
            return removeLast();
        }
        Node<T> prev = head, current;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        current = prev.next;
        T old = current.element;
        prev.next = current.next;
        current = null;
        return old;

    }

    @Override
    public T set(int index, T e) {
        if (index < 0 || index >= size) {
            return null;
        }
        if (head == null) {
            return null;
        }
        if (index == 0) {
            T old = head.element;
            head.element = e;
            return old;
        }
        if (index == size - 1) {
            T old = tail.element;
            tail.element = e;
            return old;
        }
        Node<T> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        T old = temp.element;
        temp.element = e;
        return old;
    }

    public boolean set2(int index, T o) {
        Node<T> tmp = head;
        for (int i = 0; i < size; i++) {
            if (i == index) {
                tmp.element = o;
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }

    @Override
    public String toString() {
        String s = "[";
        Node<T> n = head;
        while (n != null) {
            s += n.element;
            if (n.next != null) {
                s += ", ";
            }
            n = n.next;
        }
        return s + "]";
    }

    public T ValueAtNNodeFromLast(int n) {
        Node<T> temp = head;
        int move = size - n;
        for (int i = 0; i < move; i++) {
            temp = temp.next;
        }
        return temp.element;
    }

    public void removeafterindex(int index) {
        int d = size - index - 1;
        if (d == 3) {
            Node<T> tmp = head;
            for (int i = 0; i <= index; i++) {
                tmp = tmp.next;
            }
            tail = tmp;
            tmp = null;
            size -= 3;
        } else if (d > 3) {
            Node<T> tmp = head;
            Node<T> tmp1 = head;
            for (int i = 0; i < index; i++) {
                tmp = tmp.next;
            }
            System.out.println(tmp.element);
            for (int j = 0; j <= 4; j++) {
                tmp1 = tmp1.next;
            }
            System.out.println(tmp1.element);
            tmp.next = tmp1;
            size -= 3;
        } else {
            System.out.println("we cannot remove 3 items");
        }
    }

    public void sort() {

        Node<T> current1 = head;
        while (current1 != null) {
            Node<T> current = head;
            while (current != null) {

                if (((Comparable) current1.element).compareTo(current.element) < 0) {

                    T temp = current1.element;
                    current1.element = current.element;
                    current.element = temp;
                }
                current = current.next;
            }
            current1 = current1.next;
        }

    }

    public Node reverse(Node node) {
        Node prev = null;
        Node current = node;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    public Node reverseLinkedList(Node head) {
        if (head.next == null || head == null) {
            return head;
        }
        Node newNode = reverseLinkedList(head.next);

        head.next.next = head;
        head.next = null;

        return newNode;
    }

    private boolean checkPalindrome(Node left, Node right) {
        if (right == null) {
            return true;
        }
        boolean result = checkPalindrome(left, right.next) && (left.node.element == right.element);
        left.node = left.node.next;
        return result;
    }

    public boolean checkPalin() {
        return checkPalindrome(new Node(head), head);
    }


    public void pairSwap() {
        if (head == null || head.next == null) {
            return ;
        }
        Node current = head, previous = null;
        while (current != null && current.next != null) {
            Node tmp = current.next;
            current.next = tmp.next;
            tmp.next = current;
            if (previous == null) {
                head = tmp;
            } else {
                previous.next = tmp;
            }
            previous = current;
            current = current.next;
        }
    }

    public void print() {
        Node<T> current = head;
        System.out.print("[ ");
        while (current != null) {
            System.out.print(current.element);
            if (current.next != null) {
                System.out.print(", ");
            }
            current = current.next;
        }
        System.out.println(" ]");
    }

    public String toString2() {
        if (!isEmpty()) {
            Node<T> tmp = head;
            String result = "";
            for (int i = 0; i < size; i++) {
                if (i == size - 1) {
                    result += tmp.element;
                } else {
                    result += tmp.element + "-->";
                }
                tmp = tmp.next;
            }
            return result;
        } else {
            System.out.println("Linked List is clean");
        }
        return "";
    }
    public void change(Node head){
        Node p = head.next;
        Node n = new Node();
        n.element = 'G';
        n.next = p.next;
        p.next = n ;
        p = p.next;
        p= p.next;
        p.next.element = 'K';
    }
}
