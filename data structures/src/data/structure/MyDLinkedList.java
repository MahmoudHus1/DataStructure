package data.structure;

public class MyDLinkedList<T> extends MyAbstractList<T> implements MyList<T> {

    class Node<T> {

        T element;
        Node<T> next, previous;

        public Node() {
        }

        public Node(T e) {
            this.element = e;
        }
    }
    public Node<T> head, tail;

    public MyDLinkedList() {

    }

    public MyDLinkedList(T[] data) {
        super(data);
    }

    public void addFirst(T e) {
        Node<T> newNode = new Node<>(e);
        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            newNode.next = head;
            head.previous = newNode;
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
            newNode.previous = tail;
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
            head.previous = null;
            return old;
        }
        return null;
    }

    public T removeLast() {
        if (tail == null) {
            return null;
        } else if (head == tail) {
            return removeFirst();
        } else {
            Node<T> current = tail.previous;
            T temp = tail.element;
            tail.previous = null;
            tail = current;
            tail.next = null;
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
            newNode.previous = temp;
            temp.next = newNode;
            newNode.next.previous = newNode;
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
        if (head.element.equals(e)) {
            return removeFirst();
        } else if (tail.element.equals(e)) {
            return removeLast();

        } else if (head == null) {
            return null;
        }
        Node<T> prev = head, current;
        for (int i = 0; i < size - 1; i++) {
            current = prev.next;
            if (current.element.equals(e)) {
                prev.next = current.next;
                current.next.previous = prev;
                current.next = current.previous = null;
                return e;
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

    public void removeDuplicateNode(Node<Integer> head) {
        Node<Integer> current;
        Node<Integer> i;
        Node<Integer> temp;
        if (head != null) {
            current = head;
            while (current != null) {
                i = current.next;
                while (i != null) {
                    if (current.element.equals(i.element)) {
                        temp = i;
                        i.previous.next = i.next;
                        if (i.next != null) {
                            i.next.previous = i.previous;
                        }
                        temp = null;
                    }
                    i = i.next;
                }
                current = current.next;
            }
        }
    }

}
