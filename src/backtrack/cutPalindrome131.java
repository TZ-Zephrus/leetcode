package backtrack;

import java.util.ArrayList;
import java.util.List;

public class cutPalindrome131 {
    List<List<String>> result = new ArrayList<>();
    List<String> path = new ArrayList<>();


    public List<List<String>> partition(String s) {
        backtrack(s, 0);
        return result;
    }

    public void backtrack(String s, int startIndex) {
        if (startIndex == s.length()) {
            result.add(new ArrayList<>(path));
        }
        for (int i = startIndex+1; i <= s.length(); i++) {
            String substr = s.substring(startIndex, i);
            if (!isPalindrome(substr)) {
                continue;
            }
            path.add(substr);
            backtrack(s, i);
            path.remove(path.size()-1);
        }
    }

    public boolean isPalindrome(String s) {
        for (int i = 0; i < s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length()-1-i)) {
                return false;
            }
        }
        return true;
    }
}
