package data.structure;

class Node<T> {

    T data;
    Node next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

public class MyQueueLinked<T> {

    private static Node rear = null, front = null;
    int size = 0;

    public T dequeue() {
        if (front == null) {
            System.out.print("\nQueue Underflow");
            System.exit(1);
        }

        Node temp = front;

        front = front.next;

        if (front == null) {
            rear = null;
        }

        T item = (T) temp.data;
        size--;
        return item;
    }

    public void enqueue(T item) {
        Node node = new Node(item);
        if (front == null) {
            front = node;
            rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
        size++;
    }

    public T peek() {
        if (front != null) {
            return (T) front.data;
        } else {
            System.exit(1);
        }

        return null;
    }

    public static boolean isEmpty() {
        return rear == null && front == null;
    }

    public T find(T tar) {
        Node<T> t;
        t = front;
        boolean f = false;

        while (t != null) {
            if (t.data.toString().compareTo(tar.toString()) == 0) {
                f = true;
                break;
            }
            t = t.next;
        }

        if (f) {
            return t.data;
        } else {
            return null;
        }
    }

}
