package hot100.sub_string;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class minCoverSeq76 {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            hashMap.put(t.charAt(i), hashMap.getOrDefault(t.charAt(i), 0)+1);
        }
        int len = Integer.MAX_VALUE;
        int ansL = -1;
        int ansR = -1;
        String result = "";
        int left = 0;
        int right = -1;

        while (right < s.length()) {
            right++;
            if (right < s.length() && hashMap.containsKey(s.charAt(right))) {
                hashMap.put(s.charAt(right), hashMap.get(s.charAt(right)) - 1);
            }
            while (judge(hashMap)) {
                if (right - left + 1 < len) {
                    len = right - left + 1;
                    ansL = left;
                    ansR = right + 1;
                }
                if (hashMap.containsKey(s.charAt(left))) {
                    hashMap.put(s.charAt(left), hashMap.get(s.charAt(left)) + 1);
                }
                left++;
            }
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public boolean judge(HashMap<Character, Integer> hashMap) {
        Set<Map.Entry<Character, Integer>> entries = hashMap.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            if (entry.getValue() > 0) {
                return false;
            }
        }
        return true;
    }
}
