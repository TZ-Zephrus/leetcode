package string;

//编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
//
//不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
//
//
//
//示例 1：
//
//输入：s = ["h","e","l","l","o"]
//输出：["o","l","l","e","h"]
//示例 2：
//
//输入：s = ["H","a","n","n","a","h"]
//输出：["h","a","n","n","a","H"]

public class fanzhuanzifuchuan344 {
    public static void main(String[] args) {

    }

    public void reverseString(char[] arr) {
        for (int i = 0; i < arr.length/2; i++) {
            char temp = arr[i];
            arr[i] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
        }
    }
}
