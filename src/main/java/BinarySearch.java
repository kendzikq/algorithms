public class BinarySearch {
    public static Integer iterativeSearch(int[] sortedNums, int searchedNum) {

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

    public static Integer recursiveSearch(int[] sortedNums, int searchedNum) {
        return recursiveSearch(sortedNums, searchedNum, 0, sortedNums.length - 1);
    }

    private static Integer recursiveSearch(int[] sortedNums, int searchedNum, int min, int max) {
        if (min > max) {
            return null;
        }
        int mid = min + (max - min) / 2;
        if (sortedNums[mid] == searchedNum) {
            return mid;
        } else if (sortedNums[mid] > searchedNum) {
            return recursiveSearch(sortedNums, searchedNum, min, mid - 1);
        } else {
            return recursiveSearch(sortedNums, searchedNum, mid + 1, max);
        }
    }
}