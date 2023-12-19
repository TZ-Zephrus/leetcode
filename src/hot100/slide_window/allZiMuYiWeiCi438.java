package hot100.slide_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class allZiMuYiWeiCi438 {
    public List<Integer> findAnagrams(String s, String p) {
        int[] arr = new int[26];
        List<Integer> result = new ArrayList<>();
        if (s.length() <  p.length()) {
            return result;
        }
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            int index = c - 'a';
            arr[index]++;
        }
        for (int i = 0; i < p.length(); i++) {
            arr[s.charAt(i)-'a']--;
        }
        if (judgeNum(arr)) {
            result.add(0);
        }
        int left = 1;
        for (int right = p.length(); right < s.length(); right++) {
            arr[s.charAt(right)-'a']--;
            arr[s.charAt(left-1)-'a']++;
            if (judgeNum(arr)) {
                result.add(left);
            }
            left++;
        }
        return result;
    }

    public boolean judgeNum(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
