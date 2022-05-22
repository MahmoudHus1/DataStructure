package sortingalgorithim;

import java.util.Arrays;

public class SortingAlgorithim {

    public static void main(String[] args) {
        QuickSort sort = new QuickSort();
        Insertion sort2 = new Insertion();
        Integer[] arr1 = {5, 8, 9, 6, 2};
        String[] arr2 = {"Ahmad", "Mahmoud", "Ali", "Salma", "Mohammed"};
        System.out.println(Arrays.toString(arr2));
        sort.quicksort(arr2);
        sort2.InserstionSort(arr1);
        System.out.println(print(arr2));
        System.out.println(print(arr1));
    }

    public static <E> String print(E[] arr) {
        String s = "[";
        for (int i = 0; i < arr.length; i++) {
            s += arr[i];
            if (i != arr.length - 1) {
                s += ", ";
            }
        }
        s += "]";
        return s;
    }

}
