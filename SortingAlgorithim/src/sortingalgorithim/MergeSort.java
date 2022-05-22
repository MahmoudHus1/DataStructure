package sortingalgorithim;

public class MergeSort { // O(nLogn)

    public <E extends Comparable<E>> void MergeSort(E[] a) {
        if (a.length <= 1) {
            return;
        }
        int hSize = a.length / 2;
        E[] Larr = (E[]) new Comparable[hSize];
        E[] Rarr = (E[]) new Comparable[a.length - hSize];
        System.arraycopy(a, 0, Larr, 0, hSize);
        System.arraycopy(a, hSize, Rarr, 0, a.length - hSize);
        MergeSort(Larr);
        MergeSort(Rarr);
        Merge(a, Larr, Rarr);
    }

    public <E extends Comparable<E>> void Merge(E[] a, E[] Larr, E[] Rarr) {
        int i = 0, j = 0, k = 0;
        while (i < Larr.length && j < Rarr.length) {
            if (Larr[i].compareTo(Rarr[j]) < 0) {
                a[k++] = Larr[i++];
            } else {
                a[k++] = Rarr[j++];
            }
        }
        while (i < Larr.length) {
            a[k++] = Larr[i++];
        }
        while (j < Rarr.length) {
            a[k++] = Rarr[j++];
        }
    }
}
