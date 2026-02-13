package sorts;

public class RadixSort {

    public static void sort(int[] arr) {
        if (arr.length == 0) return;

        // Manejar negativos
        int min = arr[0];
        int max = arr[0];

        for (int num : arr) {
            if (num < min) min = num;
            if (num > max) max = num;
        }

        int offset = 0;
        if (min < 0) {
            offset = -min;
            for (int i = 0; i < arr.length; i++)
                arr[i] += offset;
            max += offset;
        }

        // Radix sort
        for (int exp = 1; max / exp > 0; exp *= 10)
            countingSort(arr, exp);

        // Restaurar valores originales
        if (offset > 0) {
            for (int i = 0; i < arr.length; i++)
                arr[i] -= offset;
        }
    }

    private static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        for (int i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        for (int i = 0; i < n; i++)
            arr[i] = output[i];
    }
}
