package sortingalgorithim;

public class Selection { // O(n^2)

    public <E extends Comparable<E>> void SelctionSort(E[] a) {
        for (int i = 0; i < a.length; i++) {
            int minPos = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j].compareTo(a[minPos]) < 0) {
                    minPos = j;
                }
            }
            if (minPos != i) {
                E temp = a[minPos];
                a[minPos] = a[i];
                a[i] = temp;
            }
        }
    }

}
