public class BinarySearch {
    public static Integer search(int[] sortedNums, int searchedNum) {

        int min = 0;
        int max = sortedNums.length - 1;

        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (sortedNums[mid] == searchedNum) {
                return mid;
            } else if (sortedNums[mid] > searchedNum) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return null;
    }
}