package some;

public class Erfen {
    public class BinarySearch {
        public static int binarySearch(int[] arr, int target) {
            int left = 0;
            int right = arr.length;

            while (left < right) {
                int mid = left + (right - left) / 2;

                if (arr[mid] == target) {
                    return mid;
                } else if (arr[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            return -1;
        }
    }
}
