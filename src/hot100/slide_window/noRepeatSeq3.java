package hot100.slide_window;

import java.util.HashMap;
import java.util.Map;

public class noRepeatSeq3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character ,Integer> map = new HashMap<>();
        int left = 0;
        int max = 0;
        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                int index = map.get(s.charAt(right));
                left = Math.max(left, index+1);
            }
            map.put(s.charAt(right), right);
            if (max < right - left + 1) {
                max = right - left + 1;
            }
        }
        return max;

    }
}
