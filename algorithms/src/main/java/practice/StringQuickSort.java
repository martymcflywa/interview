package practice;

/**
 * Created by poncem on 12/7/17.
 */
public class StringQuickSort {

    public static void sort(String[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(String[] array, int left, int right) {
        if(left >= right) {
            return;
        }
        String pivot = array[(left + right) / 2];
        int wall = partition(array, left, pivot, right);
        quickSort(array, left, wall - 1);
        quickSort(array, wall, right);
    }

    private static int partition(String[] array, int left, String pivot, int right) {
        while(left <= right) {
            while(array[left].compareTo(pivot) < 0) {
                left++;
            }
            while(array[right].compareTo(pivot) > 0) {
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

    private static void swap(String[] array, int left, int right) {
        if(left == right) {
            return;
        }
        String temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
