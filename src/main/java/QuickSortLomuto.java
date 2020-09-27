public class QuickSortLomuto {

    public static int[] sort(int[] ints) {
        return sort(ints, 0, ints.length - 1);
    }

    private static int[] sort(int[] ints, int low, int high) {
        if (low < high) {
            int p = partition(ints, low, high);
            sort(ints, low, p - 1);
            sort(ints, p + 1, high);
        }
        return ints;
    }

    private static int partition(int[] ints, int low, int high) {
        int pivot = ints[high];
        int pivotIdx = high;
        int i = low;

        for (int j = low; j < high; j++) {
            if (ints[j] <= pivot) {
                int temp = ints[i];
                ints[i] = ints[j];
                ints[j] = temp;
                i++;
            }
        }
        int temp = ints[i];
        ints[i] = pivot;
        ints[pivotIdx] = temp;
        return i;
    }
}
