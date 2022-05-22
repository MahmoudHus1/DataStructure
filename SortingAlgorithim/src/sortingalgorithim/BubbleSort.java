package sortingalgorithim;

public class BubbleSort { // O(n^2)

    public <E extends Comparable<E>> void BubbleSort(E a[]) {
        int pass = 1;
        boolean exChange;
        do {
            exChange = false;
            for (int i = 0; i < a.length - pass; i++) {
                if (a[i].compareTo(a[i + 1]) > 0) {
                    E temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                    exChange = true;
                }
            }
            pass++;
        } while (exChange);
    }
}
