package hashtable;

//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
//
//注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
//
//
//示例 1:
//
//输入: s = "anagram", t = "nagaram"
//输出: true
//示例 2:
//
//输入: s = "rat", t = "car"
//输出: false

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

public class zimuyiweici242 {
    public static void main(String[] args) {
        String s = "car";
        String t = "carttttt";
        System.out.println(isAnagram(s, t));
    }


    //用hashmap存每个字母和他出现的次数
    public static boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> hms = putIntoHashMap(s);
        HashMap<Character, Integer> hmt = putIntoHashMap(t);
        Set<Map.Entry<Character, Integer>> entriesS = hms.entrySet();
        if (hms.equals(hmt)) {
            return true;
        }
        //不需要这段
//        for (Map.Entry<Character, Integer> entry : entriesS) {
//            if (!hmt.containsKey(entry.getKey())) {
//                return false;
//            } else if (!hmt.get(entry.getKey()).equals(entry.getValue())) {
//                return false;
//            }
//        }

        return false;
    }

    //把字符串存到hashmap中
    public static HashMap<Character, Integer> putIntoHashMap(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hm.containsKey(c)) {
                int num = hm.get(c) + 1;
                hm.put(c, num);
            } else {
                hm.put(c, 1);
            }
        }
        return hm;
    }
}
