package hot100.back_track;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition131 {
    List<List<String>> result = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtrack(s, 0);
        return result;
    }

    public void backtrack(String s, int startIndex) {
        if (startIndex == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex+1; i <= s.length(); i++) {
            String sub = s.substring(startIndex, i);
            path.add(sub);
            if (isPalindrome(sub)) {
                backtrack(s, i);
            }
            path.remove(path.size()-1);
        }
    }

    public boolean isPalindrome(String sb) {
        for (int i = 0; i < sb.length()/2; i++) {
            if (sb.charAt(i) != sb.charAt(sb.length()-1-i)) {
                return false;
            }
        }
        return true;
    }

}
