package array;

public class erfenchazhao704 {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 12;
        System.out.println(search(nums, target));
        System.out.println(search2(nums, target));
    }

    //我啊 已经可以速通二分查找了
    public static int search3(int[] nums, int target) {
        int min = 0;
        int mid = nums.length/2;
        int max = nums.length;
        while (true) {

            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                max = mid;
                mid = (mid - min)/2 + min;
            } else if (target > nums[mid]) {
                min = mid + 1;
                mid = (max - mid)/2 + mid;
            }
            if (min <= max) return -1;
        }
    }



    public static int search(int[] nums, int target) {
        int max = nums.length-1;
        int min = 0;
        int mid = (max+min)/2;
        if (nums[max] == target){
            return max;
        }
        if (nums[min] == target){
            return min;
        }
        while (true){
            //这里是退出条件，当max或min和mid一直相等时，说明此时搜索范围min和max不能变了，两者挨到了一起。
            //但这种方式实际上不太好，因为没有办法判断初始位置0和length-1位置的元素是否满足条件,得事先补一条
            if ((mid == min) || (max == mid))
                return -1;
            if (target > nums[mid]){
                min = mid;
                mid = (max+min)/2;
            } else if (target < nums[mid]){
                max = mid;
                mid = (max+min)/2;
            } else if (target == nums[mid]){
                //找到了
                return mid;
            }
        }
    }

    public static int search2(int[] nums, int target) {
        int max = nums.length - 1;
        int min = 0;
        int mid = (max + min) / 2;
        while (true) {
            if (min > max)
                return -1;
            if (target > nums[mid]) {
                min = mid + 1;
                mid = (max + min) / 2;
            } else if (target < nums[mid]) {
                max = mid - 1;
                mid = (max + min) / 2;
            } else if (target == nums[mid]) {
                //找到了
                return mid;
            }
        }
    }
}
