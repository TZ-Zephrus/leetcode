package string;

//给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
//
//如果剩余字符少于 k 个，则将剩余字符全部反转。
//如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
//
//
//示例 1：
//
//输入：s = "abcdefg", k = 2
//输出："bacdfeg"
//示例 2：
//
//输入：s = "abcd", k = 2
//输出："bacd"
//
//

import java.util.Arrays;

public class fanzhuanzifuchuaner541 {
    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        System.out.println(reverseStr(s,k));
    }
    public static String reverseStr (String s, int k) {
        char[] arr = s.toCharArray();
        int count = arr.length/(2*k);
        int remain = arr.length%(2*k);
        int i = 0 ;
        while (i < count) {
            swap(arr, i*2*k, i*2*k+k);
            i++;
        }
        if (remain > k) {
            swap(arr, count*2*k, count*2*k+k);
        } else {
            swap(arr, count*2*k, arr.length);

        }
        return new String(arr);
    }

    public static void swap (char[] arr, int start, int end) {
        for (int i = start; i < (end-start)/2+start; i++) {
            char temp = arr[i];
            arr[i] = arr[end-1-(i-start)];
            arr[end-1-(i-start)] = temp;
        }
    }
}
