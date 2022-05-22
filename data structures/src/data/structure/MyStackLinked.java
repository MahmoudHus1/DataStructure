package data.structure;

import java.util.*;

public class MyStackLinked<T> {

    private LinkedList<T> list = new LinkedList<>();

    public MyStackLinked() {

    }

    public void push(T e) {
        list.addLast(e);
    }

    public T pop() {
        return list.removeLast();
    }

    public T peek() {
        return list.getLast();
    }

    public void clear() {
        list = new LinkedList<>();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean contains(T e) {
        return list.contains(e);
    }

    public int size() {
        return list.size();
    }

    public void addToStack(int index, T value) {
        if (index > list.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (list.size() == index) {
            push(value);
        } else {
            T temp = pop();
            addToStack(index, value);
            push(temp);
        }
    }

    public void removeFromStack(int index) {
        if (index >= list.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (list.size() == index + 1) {
            pop();
        } else {
            T temp = pop();
            removeFromStack(index);
            push(temp);
        }
    }    

    @Override
    public String toString() {
        return list.toString();
    }

}
