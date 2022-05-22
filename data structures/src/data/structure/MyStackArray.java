
package data.structure;

public class MyStackArray<T> {
    
    private T arr[];
    private int top;
    private int cap;

    MyStackArray(int size) {
        arr =(T[]) new Object[size];
        cap = size;
        top = -1;
    }

    public void push(T x) {
        if (isFull()) {
            System.out.println("OverFlow\nProgram Terminated\n");
            System.exit(1);
        }

        arr[++top] = x;
    }

    public T pop() {
        if (isEmpty()) {
            System.out.println("UnderFlow\nProgram Terminated");
            System.exit(1);
        }


        return arr[top--];
    }

    public T peek() {
        if (!isEmpty()) {
            return arr[top];
        } else {
            System.exit(1);
        }

        return null;
    }

    public int size() {
        return top + 1;
    }

    public Boolean isEmpty() {
        return top == -1;
    }

    public Boolean isFull() {
        return top == cap - 1;
    }

}
