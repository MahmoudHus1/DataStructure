package sortingalgorithim;

public class QuickSort {

    public <E extends Comparable<E>> void quicksort(E[] arr) {
        if (arr == null) {
            return;
        }
        quicksort(arr, 0, arr.length - 1);
    }

    private <E extends Comparable<E>> void quicksort(E[] arr, int lo, int hi) {
        if (hi > lo) {
            int splitPoint = partition(arr, lo, hi);
            quicksort(arr, lo, splitPoint-1);
            quicksort(arr, splitPoint + 1, hi);
        }
    }

    private <E extends Comparable<E>> int partition(E[] arr, int lo, int hi) {
        E pivot = arr[lo];
        int low = lo + 1, high = hi;
        while (high > low) {
            while (arr[high].compareTo(pivot) > 0) {
                high--;
            }
            while (arr[low].compareTo(pivot) <= 0 && high >= low) {
                low++;
            }
            if (low < high) {
                swap(arr, low, high);
            }
        }
        if (arr[high].compareTo(pivot) < 0) {
            arr[lo] = arr[high];
            arr[high] = pivot;
            return high;
        } else {
            return lo;
        }
    }

    private <E extends Comparable<E>> void swap(E[] arr, int i, int j) {
        E tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
