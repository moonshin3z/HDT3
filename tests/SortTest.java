package tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import sorts.*;

public class SortTest {

    @Test
    public void testGnomeSort() {
        int[] arr = {5, 2, 8, 1, 9};
        GnomeSort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 5, 8, 9}, arr);
    }

    @Test
    public void testMergeSort() {
        int[] arr = {5, 2, 8, 1, 9};
        MergeSort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 5, 8, 9}, arr);
    }

    @Test
    public void testQuickSort() {
        int[] arr = {5, 2, 8, 1, 9};
        QuickSort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 5, 8, 9}, arr);
    }

    @Test
    public void testRadixSort() {
        int[] arr = {5, 2, 8, 1, 9};
        RadixSort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 5, 8, 9}, arr);
    }

    @Test
    public void testHeapSort() {
        int[] arr = {5, 2, 8, 1, 9};
        HeapSort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 5, 8, 9}, arr);
    }

    @Test
    public void testNegativeNumbers() {
        int[] arr = {-5, 3, -1, 7, -9};
        RadixSort.sort(arr);
        assertArrayEquals(new int[]{-9, -5, -1, 3, 7}, arr);
    }

    @Test
    public void testAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        QuickSort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testReverseSorted() {
        int[] arr = {5, 4, 3, 2, 1};
        MergeSort.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testDuplicates() {
        int[] arr = {3, 1, 4, 1, 5};
        HeapSort.sort(arr);
        assertArrayEquals(new int[]{1, 1, 3, 4, 5}, arr);
    }

    @Test
    public void testEmpty() {
        int[] arr = {};
        GnomeSort.sort(arr);
        assertArrayEquals(new int[]{}, arr);
    }
}
