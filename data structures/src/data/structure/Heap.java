package data.structure;

import java.util.ArrayList;
import java.util.Collections;

public class Heap<E> {

    private final ArrayList<E> LIST = new ArrayList<>();

    public Heap() {
    }

    public Heap(E e) {
        add(e);
    }

    public Heap(E e[]) {
        for (E x : e) {
            add(x);
        }
    }

    public void add(E e) {
        LIST.add(e);
        int child = size() - 1;
        int parent = (child - 1) / 2;
        while (parent >= 0 && (((Comparable) LIST.get(child)).compareTo(LIST.get(parent)) > 0)) {
            Collections.swap(LIST, parent, child);
            child = parent;
            parent = (child - 1) / 2;
        }
    }

    public E remove() {
        if (size() == 0) {
            return null;
        }
        if (size() == 1) {
            return LIST.remove(0);
        }

        E elemnt = LIST.get(0);
        LIST.set(0, LIST.remove(size() - 1));
        int index = 0;
        while (index < size()) {
            int leftIndex = 2 * index + 1;
            int rightIndex = 2 * index + 2;
            if (leftIndex >= size()) {
                break;
            }
            int maxIndex = leftIndex;
            if (rightIndex < size()) {
                if (((Comparable) LIST.get(rightIndex)).compareTo(LIST.get(maxIndex)) > 0) {
                    maxIndex = rightIndex;
                }
            }
            if (((Comparable) LIST.get(maxIndex)).compareTo(LIST.get(index)) > 0) {
                Collections.swap(LIST, maxIndex, index);
                index = maxIndex;
            } else {
                break;
            }
        }
        return elemnt;
    }

    public void swap(int firstIndex, int secondIndex) {
        LIST.set(firstIndex, LIST.set(secondIndex, LIST.get(firstIndex)));
    }

    public int size() {
        return LIST.size();
    }

    public E get(int i) {
        return LIST.get(i);
    }

    public boolean isMaxHeap(Integer[] array) {
        boolean flag = true;
        int lastParentIndex = (array.length - 2) / 2;
        for (int i = lastParentIndex; i >= 0; i--) {
            if (isMaxHeap(array, i) == false) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public boolean isMaxHeap(Integer[] array, int parentIndex) {
        int leftChildIndex = 2 * parentIndex + 1;
        int rightChildIndex = 2 * parentIndex + 2;
        int maxIndex = parentIndex;

        if (leftChildIndex < array.length && array[leftChildIndex] > array[maxIndex]) {
            return false;
        } else if (rightChildIndex < array.length && array[rightChildIndex] > array[maxIndex]) {
            return false;
        }
        return true;
    }

    public String toString() {
        String s = "[";
        for (int i = 0; i < size(); i++) {
            s += get(i);
            if (i != size() - 1) {
                s += ", ";
            }
        }
        s += "]";
        return s;
    }

    public void sort(E arr[]) {
        Heap<E> list = new Heap<>(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = list.remove();
        }
    }

}
