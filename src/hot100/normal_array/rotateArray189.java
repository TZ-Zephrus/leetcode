package hot100.normal_array;

public class rotateArray189 {
    public void rotate(int[] nums, int k) {
        int n = k % nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, n-1);
        reverse(nums, n, nums.length-1);
    }

    public void reverse(int[] arr, int startIndex, int endIndex) {
        for (int i = startIndex; i <= (endIndex-startIndex)/2 + startIndex && startIndex < endIndex; i++) {
            int temp = arr[i];
            arr[i] = arr[endIndex-(i-startIndex)];
            arr[endIndex-(i-startIndex)] = temp;
        }
    }
}
