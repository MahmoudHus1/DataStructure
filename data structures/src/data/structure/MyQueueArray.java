package data.structure;

public class MyQueueArray<T> {

    private T arr[];
    private int front;
    private int rear;
    private int capacity;
    private int count;

    MyQueueArray(int size) {
        arr = (T[]) new Object[size];
        capacity = size;
        front = 0;
        rear = -1;
        count = 0;
    }

    public T dequeue() {
        if (isEmpty()) {
            System.out.println("UnderFlow\nProgram Terminated");
            System.exit(1);
        }

        T old = arr[front];

        front = (front + 1) % capacity;
        count--;
        return old;
    }

    public void enqueue(T item) {
        if (isFull()) {
            System.out.println("OverFlow\nProgram Terminated");
            System.exit(1);
        }

        rear = (rear + 1) % capacity;
        arr[rear] = item;
        count++;
    }

    public T peek() {
        if (isEmpty()) {
            System.out.println("UnderFlow\nProgram Terminated");
            System.exit(1);
        }
        return arr[front];
    }

    public int size() {
        return count;
    }

    public Boolean isEmpty() {
        return (size() == 0);
    }

    public Boolean isFull() {
        return (size() == capacity);
    }

}
