public class SelectionSort {

    public static int[] sort(int[] ints) {

        for (int i = 0; i < ints.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < ints.length; j++) {
                if (ints[j] < ints[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = ints[i];
            ints[i] = ints[minIdx];
            ints[minIdx] = temp;
        }
        return ints;
    }
}