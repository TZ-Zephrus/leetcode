package hashtable;

//383. 赎金信
//简单
//791
//相关企业
//给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
//
//如果可以，返回 true ；否则返回 false 。
//
//magazine 中的每个字符只能在 ransomNote 中使用一次。
//
//示例 1：
//
//输入：ransomNote = "a", magazine = "b"
//输出：false
//示例 2：
//
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
//示例 3：
//
//输入：ransomNote = "aa", magazine = "aab"
//输出：true

import java.util.HashMap;

public class shujinxin383 {
    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";
        System.out.println(canConstruct(ransomNote, magazine));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            if (hm.containsKey(magazine.charAt(i))) {
                int value = hm.get(magazine.charAt(i));
                hm.put(magazine.charAt(i), value+1);
            } else {
                hm.put(magazine.charAt(i), 1);
            }
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (!hm.containsKey(ransomNote.charAt(i))) {
                return false;
            } else {
                int value = hm.get(ransomNote.charAt(i));
                if (value == 1) {
                    hm.remove(ransomNote.charAt(i));
                } else {
                    hm.put(ransomNote.charAt(i), value-1);
                }
            }
        }
        return true;
    }
}
