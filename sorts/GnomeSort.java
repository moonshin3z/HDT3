package sorts;

public class GnomeSort {

    public static void sort(int[] arr) {
        int index = 0;

        while (index < arr.length) {
            if (index == 0) {
                index++;
            } else if (arr[index] >= arr[index - 1]) {
                index++;
            } else {
                // Swap
                int temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--;
            }
        }
    }
}
