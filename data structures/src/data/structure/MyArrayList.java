package data.structure;

public class MyArrayList<T> implements MyList<T> {

    private int size = 0;
    private final int INITIAL_CAPACITY = 16;
    private T[] data = (T[]) new Object[INITIAL_CAPACITY];

    public MyArrayList() {
    }

    public MyArrayList(T[] objects) {
        for (T object : objects) {
            add(object);
        }
    }

    private void trimToSize() {
        if (size != data.length) {
            T[] newData = (T[]) (new Object[size]);
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }

    private void ensureCapacity() {
        if (size >= data.length) {
            T[] data2 = (T[]) new Object[size * 2 + 1];
            System.arraycopy(data, 0, data2, 0, size);
            data = data2;
        }
    }

    private boolean checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index" + index + "out of bounds");
        } else {
            return true;
        }
    }

    @Override
    public void add(T e) {
        add(size, e);
    }

    @Override
    public void add(int index, T e) {
        ensureCapacity();
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    @Override
    public void clear() {
        T[] data2 = (T[]) new Object[INITIAL_CAPACITY];
        data = data2;
        size = 0;
    }

    @Override
    public boolean contains(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    @Override
    public int indexOf(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int lastIndexOf(T t) {
        for (int i = size - 1; i >= 0; i--) {
            if (data[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public T remove(T t) {
        int index = indexOf(t);
        if (index == -1) {
            return null;
        }
        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        return t;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeByIndex(int index) {
        checkIndex(index);
        T obj = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
        return obj;
    }

    @Override
    public T set(int index, T e) {
        checkIndex(index);
        T obj = data[index];
        data[index] = e;
        return obj;
    }

    @Override
    public String toString() {
        String s = "[ ";
        for (int i = 0; i < size; i++) {
            s += get(i);
            if (i != size - 1) {
                s += ", ";
            }
        }
        s += " ]";
        return s;
    }

    public void rotateToRight(int n) {
        T x;
        for (int i = 1; i <= n; i++) {
            x = data[size - 1];
            add(0, x);
            removeByIndex(size - 1);
        }
    }

    public void swap(int firstIndex, int secondIndex) {
        if (checkIndex(firstIndex) && checkIndex(secondIndex)) {
            set(firstIndex, set(secondIndex, get(firstIndex)));
        }
    }

    public void rotateToRight2(int ind) {
        int d = size;
        T temp[] = (T[]) new Object[ind];
        for (int i = 0; i < ind; i++) {
            temp[i] = (T) data[i];
        }
        for (int i = ind; i < d; i++) {
            data[i - ind] = data[i];
        }
        for (int i = 0; i < ind; i++) {
            data[i + d - ind] = temp[i];
        }
    }

    public void findMaximumProduct(MyArrayList<Integer> list) {
        int maxProduct = Integer.MIN_VALUE;
        int maxI = -1, maxJ = -1;
        for (int i = 0; i < list.size - 1; i++) {
            for (int j = i + 1; j < list.size; j++) {
                if (maxProduct < list.get(i) * list.get(j)) {
                    maxProduct = list.get(i) * list.get(j);
                    maxI = i;
                    maxJ = j;
                }
            }
        }
        System.out.println("Pair is (" + list.get(maxI) + ", " + list.get(maxJ) + ")");
    }

    public void reverseArray() {
        T[] newData = (T[]) new Object[size];
        int j = 0;
        for (int i = size - 1; i >= 0; i--) {
            newData[j] = data[i];
            j++;
        }
        data = newData;
    }

    public void reverse(MyArrayList arr) {
        int j = arr.size - 1;
        for (int i = 0; i < arr.size / 2; i++) {
            T temp = (T) arr.get(i);
            arr.set(i, arr.get(j));
            arr.set(j, temp);
            j--;
        }
    }

    public String reverseString(String str) {
        char ch[] = str.toCharArray();
        String rev = "";
        for (int i = ch.length - 1; i >= 0; i--) {
            rev += ch[i];
        }
        return rev;
    }

    public MyArrayList duplicate(MyArrayList o) {
        for (int i = 0; i < o.size - 1; i++) {
            for (int j = i + 1; j < o.size; j++) {
                if (o.get(i).equals(o.get(j))) {
                    removeByIndex(j);
                }
            }
        }
        return o;
    }

    public static MyArrayList reversArrayString(MyArrayList arr) {

        for (int i = 0; i < arr.size() / 2; i++) {
            arr.set(i, arr.set(arr.size() - 1 - i, arr.get(i)));

        }

        return reverscharString(arr);

    }

    public static MyArrayList reverscharString(MyArrayList<String> arr) {
        for (int j = 0; j < arr.size; j++) {
            String str = arr.get(j);
            char ch[] = str.toCharArray();
            String rev = "";
            for (int i = ch.length - 1; i >= 0; i--) {
                rev += ch[i];
            }
            arr.set(j, rev);
        }
        return arr;
    }

    public T removeLastByRecursion(int x) {
        if (x == size - 1) {
            T old = removeByIndex(x);
            return old;
        }
        return removeLastByRecursion(++x);
    }

}
