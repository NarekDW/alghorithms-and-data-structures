package _2_Sorting._2_2_Mergesort;

import java.util.ArrayList;

import static _2_Sorting._2_1_Elementary_Sorts.SortUtils.less;
import static _2_Sorting._2_1_Elementary_Sorts.SortUtils.show;

@SuppressWarnings("ALL")
public class Merge {

    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        int n = a.length;
        aux = new Comparable[n];
        sort(a, 0, n - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi) {
        // Merge a[lo..mid] with a[mid+1..hi].
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];

        for (int k = lo; k <= hi; k++)
            if (j > hi)                     a[k] = aux[i++];
            else if (i > mid)               a[k] = aux[j++];
            else if (less(aux[j], aux[i]))  a[k] = aux[j++];
            else                            a[k] = aux[i++];
    }

    public static void main(String[] args) {
        String[] input = "MERGESORTEXAMPLE".split("");
        sort(input);
        show(input);
    }

}
