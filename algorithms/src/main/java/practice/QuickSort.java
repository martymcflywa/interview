package practice;

/**
 * Created by poncem on 11/7/17.
 */
public class QuickSort {

    public static void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int left, int right) {
        if(left >= right) {
            return;
        }
        int pivot = array[(left + right) / 2];
        int wall = partition(array, left, pivot, right);
        quickSort(array, left, wall - 1);
        quickSort(array, wall, right);
    }

    private static int partition(int[] array, int left, int pivot, int right) {
        while(left <= right) {
            while(array[left] < pivot) {
                left++;
            }
            while(array[right] > pivot) {
                right--;
            }
            if(left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
