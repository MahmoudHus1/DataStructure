package sortingalgorithim;

public class Insertion { // O(n^2)

    public <E extends Comparable<E>> void InserstionSort(E[] a) {
        for (int i = 1; i < a.length; i++) {
            InserstionInsert(a, i);
        }
    }

    private <E extends Comparable<E>> void InserstionInsert(E[] a, int nextPos) {
        E nextVal = a[nextPos];
        while (nextPos > 0 && nextVal.compareTo(a[nextPos - 1]) < 0) {
            a[nextPos] = a[nextPos - 1];
            nextPos--;
        }
        a[nextPos] = nextVal;
    }

}
